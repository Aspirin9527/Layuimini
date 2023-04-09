package me.liuhui.mall.repository.dao;


import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.AdminLoginRecord;
import me.liuhui.mall.repository.model.annotation.MapperMapping;

@MapperMapping(table = "s_admin_login_record")
public interface AdminLoginRecordDao extends BaseDao<AdminLoginRecord,Long> {
	
}
