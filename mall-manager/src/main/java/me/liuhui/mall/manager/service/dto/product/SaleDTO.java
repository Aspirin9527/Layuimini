package me.liuhui.mall.manager.service.dto.product;

import lombok.Data;

@Data
public class SaleDTO {

    private Integer saleId;
    private Integer productId;
    private Integer userId;
    private Double salePrice;
    private Integer saleNum;
    private Double saleSum;
    private String saleDate;
}
