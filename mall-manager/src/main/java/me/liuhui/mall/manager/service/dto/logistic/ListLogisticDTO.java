package me.liuhui.mall.manager.service.dto.logistic;

import me.liuhui.mall.common.base.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ListLogisticDTO extends PageDTO {


    private Integer id;

    private String name;

    private String code;

    private String companyUrl;

    private Double weight;


}
