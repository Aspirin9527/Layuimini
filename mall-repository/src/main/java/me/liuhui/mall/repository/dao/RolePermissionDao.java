package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.RolePermission;
import me.liuhui.mall.repository.model.annotation.MapperMapping;


@MapperMapping(table = "s_role_permission")
public interface RolePermissionDao extends BaseDao<RolePermission,Long> {
    void deleteByRole(Long roleId);
}
