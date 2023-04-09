
package me.liuhui.mall.manager.service.impl;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.OrderService;
import me.liuhui.mall.manager.service.dto.order.CreateOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ListOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ModifyOrderDTO;
import me.liuhui.mall.manager.service.mapstruct.OrderConverter;
import me.liuhui.mall.manager.service.vo.order.ListOrderVO;
import me.liuhui.mall.repository.dao.OrderDao;
import me.liuhui.mall.repository.model.Order;
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
	public ResultVO<Boolean> create(CreateOrderDTO dto) {
		Order entity = orderConverter.createDtoToEntity(dto);
		entity.setCreateTime(new Date());
		orderDao.insert(entity);
		return ResultVO.buildSuccessResult();
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
