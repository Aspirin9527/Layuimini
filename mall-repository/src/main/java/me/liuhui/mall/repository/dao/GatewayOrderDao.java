package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.GatewayOrder;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "o_gateway_order")
public interface GatewayOrderDao extends BaseDao<GatewayOrder,Long> {
	GatewayOrder selectByOrderId(Integer v) ;
	
}
