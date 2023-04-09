
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.ad.space.CreateAdSpaceDTO;
import me.liuhui.mall.manager.service.dto.ad.space.ModifyAdSpaceDTO;
import me.liuhui.mall.manager.service.vo.ad.space.AdSpaceVO;
import me.liuhui.mall.repository.model.AdSpace;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Created on 2020/10/14 18:51
 * <p>
 *
 * @author [清远]
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdSpaceConverter {

    List<AdSpaceVO> toVo(List<AdSpace> entityList);

    AdSpaceVO toVo(AdSpace adSpace);

    AdSpace createDtoToEntity(CreateAdSpaceDTO dto);

    AdSpace modifyDtoToEntity(ModifyAdSpaceDTO dto);
}
