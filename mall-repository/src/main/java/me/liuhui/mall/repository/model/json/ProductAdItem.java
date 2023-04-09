package me.liuhui.mall.repository.model.json;

import me.liuhui.mall.repository.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuhui
 * @version 1.0
 * @date 2013-5-6 下午10:34:55
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductAdItem {
    private Product product;
}
