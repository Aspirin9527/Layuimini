package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Property;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_property")
public interface PropertyDao extends BaseDao<Property,Long> {
	
}
