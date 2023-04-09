package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Category;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "p_category")
public interface CategoryDao extends BaseDao<Category,Long> {
	
}
