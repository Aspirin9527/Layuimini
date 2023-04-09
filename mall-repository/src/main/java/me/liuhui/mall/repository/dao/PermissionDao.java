package me.liuhui.mall.repository.dao;
import me.liuhui.mall.repository.dao.mybatis.provider.BaseDao;
import me.liuhui.mall.repository.model.Permission;
import me.liuhui.mall.repository.model.annotation.MapperMapping;

import java.util.List;


@MapperMapping(table = "s_permission")
public interface PermissionDao extends BaseDao<Permission,Long> {
    /**
     *
     * @param adminId
     * @return
     */
    List<Permission> selectByAdminId(Long adminId);
}
