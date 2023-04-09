package me.liuhui.mall.repository.model;

import me.liuhui.mall.repository.model.annotation.Pk;
import lombok.Data;

@Data
public class ProductDetail {
    @Pk
    private Long id;
    private Long productId;
    private String detail;

}
