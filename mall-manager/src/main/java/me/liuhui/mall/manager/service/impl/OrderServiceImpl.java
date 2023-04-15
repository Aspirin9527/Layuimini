
package me.liuhui.mall.manager.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.kmeans.Cluster;
import me.liuhui.mall.manager.kmeans.DataPoint;
import me.liuhui.mall.manager.kmeans.KMeansAlgorithm;
import me.liuhui.mall.manager.runtime.AdminSessionHolder;
import me.liuhui.mall.manager.service.OrderService;
import me.liuhui.mall.manager.service.dto.order.AnalyseOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ListOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ModifyOrderDTO;
import me.liuhui.mall.manager.service.dto.order.OrderDTO;
import me.liuhui.mall.manager.service.mapstruct.OrderConverter;
import me.liuhui.mall.manager.service.vo.auth.AuthVO;
import me.liuhui.mall.manager.service.vo.order.ListOrderVO;
import me.liuhui.mall.manager.service.vo.order.OrderAnalyseVO;
import me.liuhui.mall.repository.dao.OrderDao;
import me.liuhui.mall.repository.dao.ProductDao;
import me.liuhui.mall.repository.model.Order;
import me.liuhui.mall.repository.model.Product;
import me.liuhui.mall.repository.model.dao.OrderAnalyse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created on 2020/10/14 20:12
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderConverter orderConverter;
    @Resource
    private OrderDao orderDao;
    @Resource
    private ProductDao productDao;
    @Resource
    private KMeansAlgorithm kMeansAlgorithm;

    @Override
    public ResultVO<ListOrderVO> list(ListOrderDTO dto) {
        if (StringUtils.isBlank(dto.getOrderBy())) {
            dto.setOrderBy("id desc");
        }
        Map<String, Object> cond = dto.toMap();
        long count = orderDao.count(cond);
        List<Order> orders = orderDao.selectList(cond);
        ListOrderVO vo = new ListOrderVO();
        vo.setTotal(count);
        vo.setList(orderConverter.toVo(orders));
        return ResultVO.buildSuccessResult(vo);
    }

    @Override
    public ResultVO<Boolean> create(OrderDTO dto) {
        Product product = productDao.selectByPk(dto.getProductId());
        Integer stock = product.getStock();
        //库存要大于0才能买
        if (stock >= 0 && (stock - dto.getSaleNum() >= 0)) {
            AuthVO current = AdminSessionHolder.getCurrentAdmin();
            Snowflake snowflake = IdUtil.getSnowflake(1, 1);
            Order order = Order.builder().id(snowflake.nextId()).productId(product.getId()).status(1).totalAmount(dto.getSaleNum() * product.getPrice())
                    .payAmount(dto.getSaleNum() * product.getPrice()).totalQuantity(dto.getSaleNum()).consumerUserId(Math.toIntExact(current.getAdminId()))
                    .consigneeName(current.getRealName()).consigneeCellphone(current.getPhone()).build();
            Integer insert = orderDao.insert(order);
            if (insert > 0) {
                productDao.updateStock(product.getId(), dto.getSaleNum(), product.getVersion());
            }
            return ResultVO.buildSuccessResult();
        }
        return ResultVO.buildFailResult("购买失败，库存不足！");
    }

    @Override
    public ResultVO<Boolean> modify(ModifyOrderDTO dto) {
        Order order = orderDao.selectByPk(dto.getId());
        if (order == null) {
            return ResultVO.buildFailResult("角色不存在");
        }


        Order entity = orderConverter.modifyDtoToEntity(dto);
        orderDao.update(entity);
        return ResultVO.buildSuccessResult();
    }

    @Override
    public ResultVO<Boolean> delete(Set<Long> ids) {
        for (Long id : ids) {
            orderDao.delete(id);
        }
        return ResultVO.buildSuccessResult();
    }

    @Override
    public ResultVO<Map<String, Object>> dataAnalyse(AnalyseOrderDTO analyseOrderDTO) {
        int numClusters = 4;
        try {
            //定价-销量分析
            List<DataPoint> pricePoints = new ArrayList<>();
            // 利润-销量分析
            List<DataPoint> profitPoints = new ArrayList<>();
            Date MinCreateTime = null;
            Date MaxCreateTime = null;
            if (!analyseOrderDTO.getMinCreateTime().isEmpty() && !analyseOrderDTO.getMaxCreateTime().isEmpty()){
                MinCreateTime = new SimpleDateFormat("yyyy-MM-dd").parse(analyseOrderDTO.getMinCreateTime());
                MaxCreateTime = new SimpleDateFormat("yyyy-MM-dd").parse(analyseOrderDTO.getMaxCreateTime());
            }
            List<OrderAnalyse> orderAnalyses = orderDao.dataAnalse(MinCreateTime, MaxCreateTime);
            orderAnalyses.forEach(orderAnalyse -> {
                double[] price = new double[2];
                double[] profit = new double[2];
                price[0] = Double.parseDouble(orderAnalyse.getPrice()); // 定价
                price[1] = Double.parseDouble(orderAnalyse.getNum()); // 销量
                pricePoints.add(new DataPoint(orderAnalyse.getName(), price));
                profit[0] = Double.parseDouble((orderAnalyse.getProfit())); // 单价利润
                profit[1] = Double.parseDouble((orderAnalyse.getNum())); // 销量
                profitPoints.add(new DataPoint(orderAnalyse.getName(), profit));
            });

            if (orderAnalyses.size() < numClusters){
                return ResultVO.buildFailResult("样本数据太少，无法进行聚类分析！");
            }
            //定价-销量
            List<Cluster> priceClusters = kMeansAlgorithm.kMeansClustering(pricePoints, numClusters);
            // 利润-销量
            List<Cluster> profitClusters = kMeansAlgorithm.kMeansClustering(profitPoints, numClusters);

            Map<String, Object> map = new HashMap<>(2);
            map.put("priceClusters", buildData(priceClusters));
            map.put("profitClusters", buildData(profitClusters));
            return ResultVO.buildSuccessResult(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVO.buildFailResult(e.getMessage());
        }
    }

    /**
     * 构建分析数据
     *
     * @param clusters
     * @return
     */
    private List<OrderAnalyseVO> buildData(List<Cluster> clusters) {
        List<OrderAnalyseVO> analyseVOList = new ArrayList<>();
        for (int i = 0; i < clusters.size(); i++) {
            OrderAnalyseVO analyse = new OrderAnalyseVO();
            List<double[]> features = new ArrayList<>();
            for (DataPoint dataPoint : clusters.get(i).getDataPoints()) {
                double[] feature = dataPoint.getFeatures();
                features.add(feature);
            }
            analyse.setClusterGroup("Cluster" + (i + 1));
            analyse.setFeatures(features);
            analyseVOList.add(analyse);
        }
        return analyseVOList;
    }

}
