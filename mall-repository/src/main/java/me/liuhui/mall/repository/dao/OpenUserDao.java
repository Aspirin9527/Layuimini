package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.OpenUser;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "u_open_user")
public interface OpenUserDao extends BaseDao<OpenUser,Long> {
	
}
