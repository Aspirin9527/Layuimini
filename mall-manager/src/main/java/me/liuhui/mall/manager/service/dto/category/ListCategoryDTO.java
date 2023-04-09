package me.liuhui.mall.manager.service.dto.category;

import me.liuhui.mall.common.base.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ListCategoryDTO extends PageDTO {


    private Integer id;

    private Integer pid;

    private String name;

    private String description;

    private Double weight;

    private Integer status;

    private Date minCreateTime;
    private Date maxCreateTime;

    private String createAdmin;


}
