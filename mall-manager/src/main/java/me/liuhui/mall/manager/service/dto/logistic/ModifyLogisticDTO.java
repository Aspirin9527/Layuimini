package me.liuhui.mall.manager.service.dto.logistic;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Data
public class ModifyLogisticDTO extends CreateLogisticDTO {


    @NotNull
    private Long id;


}
