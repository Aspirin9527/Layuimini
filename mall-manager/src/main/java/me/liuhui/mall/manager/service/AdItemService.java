package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.ad.item.AdItemDTO;

import java.util.Set;


public interface AdItemService {


    ResultVO<Boolean> create(AdItemDTO dto);

    ResultVO<Boolean> modify(AdItemDTO dto);

    ResultVO<Boolean> delete(Set<Long> ids);


}
