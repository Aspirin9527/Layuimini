package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Product;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_product")
public interface ProductDao extends BaseDao<Product,Long> {

    /**
     *
     * @param id 商品id
     * @param count 购买数量
     * @param version 版本
     * @return
     */
    boolean updateStock(Long id,Integer count,Integer version);
	
}
