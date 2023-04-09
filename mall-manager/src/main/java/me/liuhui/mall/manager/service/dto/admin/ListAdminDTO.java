package me.liuhui.mall.manager.service.dto.admin;

import me.liuhui.mall.common.base.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class ListAdminDTO extends PageDTO {



    private String username;


    private String realName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minLastLoginTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxLastLoginTime;


    private Integer status;


}
