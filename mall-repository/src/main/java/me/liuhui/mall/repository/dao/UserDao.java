package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.User;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "u_user")
public interface UserDao extends BaseDao<User,Long> {
	User selectByUsername(String v) ;
	User selectByEmail(String v) ;
	
}
