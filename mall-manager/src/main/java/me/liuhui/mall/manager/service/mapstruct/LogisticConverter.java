
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.logistic.CreateLogisticDTO;
import me.liuhui.mall.manager.service.dto.logistic.ModifyLogisticDTO;
import me.liuhui.mall.manager.service.vo.logistic.LogisticVO;
import me.liuhui.mall.repository.model.Logistic;
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
public interface LogisticConverter {

    List<LogisticVO> toVo(List<Logistic> entityList);

    Logistic createDtoToEntity(CreateLogisticDTO dto);

    Logistic modifyDtoToEntity(ModifyLogisticDTO dto);
}
