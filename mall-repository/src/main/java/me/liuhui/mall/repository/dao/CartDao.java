package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Cart;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "u_cart")
public interface CartDao extends BaseDao<Cart,Long> {
	Cart selectByUserId(Integer v) ;
	
}
