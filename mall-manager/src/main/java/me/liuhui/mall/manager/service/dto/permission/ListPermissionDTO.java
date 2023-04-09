package me.liuhui.mall.manager.service.dto.permission;

import me.liuhui.mall.common.base.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ListPermissionDTO extends PageDTO {


    private Integer id;

    private Integer pid;

    private String title;

    private String code;

    private String icon;

    private Integer type;

    private String href;

    private Boolean status;

    private Date minCreateTime;
    private Date maxCreateTime;

    private Double weight;


}
