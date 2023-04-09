package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Product;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_product")
public interface ProductDao extends BaseDao<Product,Long> {
	
}
