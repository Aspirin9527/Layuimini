package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.ad.space.CreateAdSpaceDTO;
import me.liuhui.mall.manager.service.dto.ad.space.ListAdSpaceDTO;
import me.liuhui.mall.manager.service.dto.ad.space.ModifyAdSpaceDTO;
import me.liuhui.mall.manager.service.vo.ad.space.AdSpaceVO;
import me.liuhui.mall.manager.service.vo.ad.space.ListAdSpaceVO;

import java.util.Set;


/**
 * @author 清远
 */
public interface AdSpaceService {


    ResultVO<Boolean> create(CreateAdSpaceDTO dto);

    ResultVO<Boolean> modify(ModifyAdSpaceDTO dto);

    ResultVO<Boolean> delete(Set<Long> ids);

    ResultVO<ListAdSpaceVO> list(ListAdSpaceDTO dto);

    ResultVO<AdSpaceVO> detail(Long id);

    /**
     * 发布广告位
     *
     * @param id
     * @return
     */
    ResultVO<Boolean> publish(Long id);
}
