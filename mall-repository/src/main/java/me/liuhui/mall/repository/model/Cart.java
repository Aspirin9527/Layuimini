package me.liuhui.mall.repository.model;


import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

import java.util.Date;

/**
 * 
 */

@Data
public class Cart  {




    /**
     * id       db_column: id
     */

    @Pk
	private Long id;

    /**
     * userId       db_column: user_id
     */

private Integer userId;

    /**
     * createTime       db_column: create_time
     */

private Date createTime;

    /**
     * content       db_column: content
     */

private String content;







}






