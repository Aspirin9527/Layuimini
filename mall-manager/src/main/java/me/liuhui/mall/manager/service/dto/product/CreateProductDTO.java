package me.liuhui.mall.manager.service.dto.product;

import lombok.Data;


/**
 * @author 清远
 */
@Data
public class CreateProductDTO {


    private String name;

    private String picFilenames;

    private Double price;

    private Double originalPrice;

    private Double costPrice;

    private String detail;


    private String allCategoryIds;

    private Integer stock;

    private Integer salesNum;

    private Integer virtualSalesNum;



}
