
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.role.CreateRoleDTO;
import me.liuhui.mall.manager.service.dto.role.ModifyRoleDTO;
import me.liuhui.mall.manager.service.vo.role.RoleVO;
import me.liuhui.mall.repository.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * Created on 2020/10/14 18:51
 * <p>
 *
 * @author [清远]
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleConverter {

    List<RoleVO> toVo(List<Role> entityList);

    Role createDtoToEntity(CreateRoleDTO dto);

    Role modifyDtoToEntity(ModifyRoleDTO dto);
}
