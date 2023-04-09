package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Admin;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "s_admin")
public interface AdminDao extends BaseDao<Admin,Long> {
	Admin selectByUsername(String v) ;
	
}
