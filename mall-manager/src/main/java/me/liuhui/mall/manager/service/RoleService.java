package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.role.CreateRoleDTO;
import me.liuhui.mall.manager.service.dto.role.ListRoleDTO;
import me.liuhui.mall.manager.service.dto.role.ModifyRoleDTO;
import me.liuhui.mall.manager.service.vo.role.ListRoleVO;

import java.util.Set;


public interface RoleService {


	ResultVO<Boolean> create(CreateRoleDTO dto);

	ResultVO<Boolean> modify(ModifyRoleDTO dto);
	ResultVO<Boolean> delete(Set<Long> id) ;

	ResultVO<ListRoleVO>  list(ListRoleDTO dto) ;
	
	ResultVO<Set<Long>> selectPermissionIds(Long id);
}
