package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.OrderItem;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "o_order_item")
public interface OrderItemDao extends BaseDao<OrderItem,Long> {
	
}
