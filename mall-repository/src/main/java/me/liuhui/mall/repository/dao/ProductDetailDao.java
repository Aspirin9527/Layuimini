package me.liuhui.mall.repository.dao;

import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.ProductDetail;
import me.liuhui.mall.repository.model.annotation.MapperMapping;

@MapperMapping(table = "p_product_detail")
public interface ProductDetailDao extends BaseDao<ProductDetail, Long> {
    ProductDetail selectByProductId(Long productId);
}
