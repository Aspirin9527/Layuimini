package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Favorite;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "u_favorite")
public interface FavoriteDao extends BaseDao<Favorite,Long> {
	
}
