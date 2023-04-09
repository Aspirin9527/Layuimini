package me.liuhui.mall.manager.service.dto.product;

import me.liuhui.mall.common.base.dto.PageDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author 清远
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ListProductDTO extends PageDTO {


    private String likeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxCreateTime;

    private String createAdmin;

    private Integer status;

    private Integer categoryId;

}
