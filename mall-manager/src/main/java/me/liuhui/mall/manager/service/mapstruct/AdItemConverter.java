package me.liuhui.mall.manager.service.mapstruct;

import me.liuhui.mall.manager.service.dto.ad.item.AdItemDTO;
import me.liuhui.mall.manager.service.vo.ad.item.AdItemVO;
import me.liuhui.mall.repository.model.AdItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AdItemConverter {

    List<AdItemVO> toVo(List<AdItem> entityList);

    AdItem toEntity(AdItemDTO dto);

}
