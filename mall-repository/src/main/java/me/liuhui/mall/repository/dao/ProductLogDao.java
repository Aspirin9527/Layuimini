package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.ProductLog;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_product_log")
public interface ProductLogDao extends BaseDao<ProductLog,Long> {
	
}
