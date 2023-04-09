package me.liuhui.mall.repository.model;


import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

import java.util.Date;

/**
 * 
 */

@Data
public class ProductLog  {




    /**
     * id       db_column: id
     */

    @Pk
	private Long id;

    /**
     * time       db_column: time
     */

private Date time;

    /**
     * type       db_column: type
     */

private Integer type;

    /**
     * adminId       db_column: admin_id
     */

private Integer adminId;

    /**
     * productId       db_column: product_id
     */

private Integer productId;







}






