package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.AdSpaceService;
import me.liuhui.mall.manager.service.dto.ad.space.CreateAdSpaceDTO;
import me.liuhui.mall.manager.service.dto.ad.space.ListAdSpaceDTO;
import me.liuhui.mall.manager.service.dto.ad.space.ModifyAdSpaceDTO;
import me.liuhui.mall.manager.service.vo.ad.space.AdSpaceVO;
import me.liuhui.mall.manager.service.vo.ad.space.ListAdSpaceVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/ad-space")
public class AdSpaceController {

	@Resource
	private AdSpaceService adSpaceService;

	@PerCode("ad-space:mgt")
	@GetMapping("list")
	public ResultVO<ListAdSpaceVO> list(ListAdSpaceDTO dto) {
		return adSpaceService.list(dto);
	}

	@PerCode("ad-space:add")
	@PostMapping("create")
	public ResultVO<Boolean> create(@Validated @RequestBody CreateAdSpaceDTO dto) {
		return adSpaceService.create(dto);
	}

	@PerCode("ad-space:update")
	@PostMapping("modify")
	public ResultVO<Boolean> modify(@Validated @RequestBody ModifyAdSpaceDTO dto) {
		return adSpaceService.modify(dto);
	}

	@PerCode("ad-space:del")
	@DeleteMapping("delete")
	public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
		return adSpaceService.delete(ids);
	}


	@PerCode("ad:mgt")
	@GetMapping("detail")
	public ResultVO<AdSpaceVO> detail(@Validated @NotNull Long id) {
		return adSpaceService.detail(id);
	}

	@PerCode("ad:publish")
	@GetMapping("publish")
	public ResultVO<Boolean> publish(@Validated @NotNull Long id) {
		return adSpaceService.publish(id);
	}


}
