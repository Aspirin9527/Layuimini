package me.liuhui.mall.repository.model;


import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

import java.util.Date;

/**
 *
 */

@Data
public class Role {


    /**
     * id       db_column: id
     */

    @Pk
    private Long id;

    /**
     * 名称       db_column: name
     */

    private String name;

    /**
     * 描述       db_column: description
     */

    private String description;


    /**
     * 创建时间       db_column: create_time
     */

    private Date createTime;

    private String createAdmin;


}






