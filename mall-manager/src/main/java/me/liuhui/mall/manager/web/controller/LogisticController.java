package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.LogisticService;
import me.liuhui.mall.manager.service.dto.logistic.CreateLogisticDTO;
import me.liuhui.mall.manager.service.dto.logistic.ListLogisticDTO;
import me.liuhui.mall.manager.service.dto.logistic.ModifyLogisticDTO;
import me.liuhui.mall.manager.service.vo.logistic.ListLogisticVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/logistic")
public class LogisticController {

	@Resource
	private LogisticService logisticService;

	@PerCode("logistic:mgt")
	@GetMapping("list")
	public ResultVO<ListLogisticVO> list(ListLogisticDTO dto) {
		return logisticService.list(dto);
	}

	@PerCode("logistic:add")
	@PostMapping("create")
	public ResultVO<Boolean> create(@Validated @RequestBody CreateLogisticDTO dto) {
		return logisticService.create(dto);
	}

	@PerCode("logistic:update")
	@PostMapping("modify")
	public ResultVO<Boolean> modify(@Validated @RequestBody ModifyLogisticDTO dto) {
		return logisticService.modify(dto);
	}

	@PerCode("logistic:del")
	@DeleteMapping("delete")
	public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
		return logisticService.delete(ids);
	}


}
