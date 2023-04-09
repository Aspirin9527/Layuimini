package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.permission.CreatePermissionDTO;
import me.liuhui.mall.manager.service.dto.permission.ModifyPermissionDTO;
import me.liuhui.mall.manager.service.vo.admin.PermissionVO;
import me.liuhui.mall.repository.model.Permission;

import java.util.List;
import java.util.Set;

/**
 * Created on 2020/10/14 18:11
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
public interface PermissionService {
    /**
     * 当前用户权限
     * @return
     */
    List<Permission> currentPermissions();

    /**
     * 当前登录人菜单树
     *
     * @return
     */
    ResultVO<List<PermissionVO>> menuTree();

    /**
     * 所有权限树
     *
     * @return
     */
    ResultVO<List<PermissionVO>> permissionTree();

    ResultVO<List<PermissionVO>> list();

    ResultVO<Boolean> create(CreatePermissionDTO dto);


    ResultVO<Boolean> modify(ModifyPermissionDTO dto);

    ResultVO<Boolean> delete(Set<Long> ids) ;
}
