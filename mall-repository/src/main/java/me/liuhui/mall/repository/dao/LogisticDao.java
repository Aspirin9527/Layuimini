package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Logistic;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "o_logistic")
public interface LogisticDao extends BaseDao<Logistic,Long> {
	
}
