package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.permission.CreatePermissionDTO;
import me.liuhui.mall.manager.service.dto.permission.ModifyPermissionDTO;
import me.liuhui.mall.manager.service.vo.admin.PermissionVO;
import me.liuhui.mall.repository.model.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

/**
 * Created on 2020/10/14 18:51
 * <p>
 *
 * @author [清远]
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionConverter {

    Set<PermissionVO> toVo(Set<Permission> entityList);

    List<PermissionVO> toVo(List<Permission> entityList);

    Permission createDtoToEntity(CreatePermissionDTO dto);

    Permission modifyDtoToEntity(ModifyPermissionDTO dto);
}
