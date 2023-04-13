package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.order.AnalyseOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ListOrderDTO;
import me.liuhui.mall.manager.service.dto.order.ModifyOrderDTO;
import me.liuhui.mall.manager.service.dto.order.OrderDTO;
import me.liuhui.mall.manager.service.vo.order.ListOrderVO;

import java.util.Set;


public interface OrderService {


	ResultVO<Boolean> create(OrderDTO dto);

	ResultVO<Boolean> modify(ModifyOrderDTO dto);

	ResultVO<Boolean> delete(Set<Long> ids);

	ResultVO<ListOrderVO> list(ListOrderDTO dto);

    void dataAnalyse(AnalyseOrderDTO dto);
}
