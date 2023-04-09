package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Role;
import me.liuhui.mall.repository.model.annotation.MapperMapping;

import java.util.List;


@MapperMapping(table = "s_role")
public interface RoleDao extends BaseDao<Role,Long> {
    List<Long> selectPermissionIds(Long id);
}
