package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.OrderLog;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "o_order_log")
public interface OrderLogDao extends BaseDao<OrderLog,Long> {
	
}
