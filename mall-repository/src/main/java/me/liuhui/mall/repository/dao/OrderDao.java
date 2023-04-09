package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Order;
import me.liuhui.mall.repository.model.annotation.MapperMapping;
import me.liuhui.mall.repository.model.dao.DateCount;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@MapperMapping(table = "o_order")
public interface OrderDao extends BaseDao<Order,Long> {
	Order selectByNo(String v) ;

	Double sumAmount(Integer status);

	List<DateCount> countOrder(@Param("minCreateTime") Date minCreateTime, @Param("maxCreateTime") Date maxCreateTime);

}
