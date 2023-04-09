
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.admin.AdminDTO;
import me.liuhui.mall.manager.service.vo.admin.AdminVO;
import me.liuhui.mall.repository.model.Admin;
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
public interface AdminConverter {

    List<AdminVO> toVo(List<Admin> entityList);

    AdminVO toVo(Admin admin);

    Admin toEntity(AdminDTO dto);

}
