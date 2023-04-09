package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.AdItemService;
import me.liuhui.mall.manager.service.dto.ad.item.AdItemDTO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Validated
@RestController
@RequestMapping("/api/ad-item")
public class AdItemController {

    @Resource
    private AdItemService adItemService;


    @PerCode("ad:add")
    @PostMapping("create")
    public ResultVO<Boolean> create(@Validated({AdItemDTO.Add.class}) @RequestBody AdItemDTO dto) {
        return adItemService.create(dto);
    }

    @PerCode("ad:update")
    @PostMapping("modify")
    public ResultVO<Boolean> modify(@Validated({AdItemDTO.Update.class}) @RequestBody AdItemDTO dto) {
        return adItemService.modify(dto);
    }

    @PerCode("ad:del")
    @DeleteMapping("delete")
    public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
        return adItemService.delete(ids);
    }


}
