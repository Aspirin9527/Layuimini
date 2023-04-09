package me.liuhui.mall.repository.dao;

import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.AdminRole;
import me.liuhui.mall.repository.model.annotation.MapperMapping;

import java.util.List;


@MapperMapping(table = "s_admin_role")
public interface AdminRoleDao extends BaseDao<AdminRole, Long> {

    void deleteByAdmin(Long adminId);

    List<AdminRole> selectRoleByAdmin(List<Long> adminIds);
}
