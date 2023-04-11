
package me.liuhui.mall.manager.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.runtime.AdminSessionHolder;
import me.liuhui.mall.manager.service.OrderService;
import me.liuhui.mall.manager.service.ProductService;
import me.liuhui.mall.manager.service.dto.order.ListOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ModifyOrderDTO;
import me.liuhui.mall.manager.service.dto.order.OrderDTO;
import me.liuhui.mall.manager.service.mapstruct.OrderConverter;
import me.liuhui.mall.manager.service.vo.auth.AuthVO;
import me.liuhui.mall.manager.service.vo.order.ListOrderVO;
import me.liuhui.mall.repository.dao.OrderDao;
import me.liuhui.mall.repository.dao.ProductDao;
import me.liuhui.mall.repository.model.Order;
import me.liuhui.mall.repository.model.Product;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        if (stock > 0 && (stock - dto.getSaleNum() > 0)) {
            boolean b = productDao.updateStock(product.getId(), dto.getSaleNum(), product.getVersion());
            if (b) {
                AuthVO current = AdminSessionHolder.getCurrentAdmin();
                Snowflake snowflake = IdUtil.getSnowflake(1, 1);
                Order order = Order.builder().id(snowflake.nextId()).productId(product.getId()).status(1).totalAmount(dto.getSaleNum() * product.getPrice())
                        .payAmount(dto.getSaleNum() * product.getPrice()).totalQuantity(dto.getSaleNum()).consumerUserId(Math.toIntExact(current.getAdminId()))
                        .consigneeName(current.getRealName()).consigneeCellphone(current.getPhone()).build();
                orderDao.insert(order);
                return ResultVO.buildSuccessResult();
            }
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

}
