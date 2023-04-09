package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.ConsigneeInfo;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "u_consignee_info")
public interface ConsigneeInfoDao extends BaseDao<ConsigneeInfo,Long> {
	
}
