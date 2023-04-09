package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.logistic.CreateLogisticDTO;
import me.liuhui.mall.manager.service.dto.logistic.ListLogisticDTO;
import me.liuhui.mall.manager.service.dto.logistic.ModifyLogisticDTO;
import me.liuhui.mall.manager.service.vo.logistic.ListLogisticVO;

import java.util.Set;


public interface LogisticService {


	ResultVO<Boolean> create(CreateLogisticDTO dto);

	ResultVO<Boolean> modify(ModifyLogisticDTO dto);

	ResultVO<Boolean> delete(Set<Long> ids);

	ResultVO<ListLogisticVO> list(ListLogisticDTO dto);


}
