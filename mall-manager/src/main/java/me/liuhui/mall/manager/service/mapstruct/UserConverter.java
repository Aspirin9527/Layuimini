
package me.liuhui.mall.manager.service.mapstruct;


import me.liuhui.mall.manager.service.dto.user.CreateUserDTO;
import me.liuhui.mall.manager.service.dto.user.ModifyUserDTO;
import me.liuhui.mall.manager.service.vo.user.UserVO;
import me.liuhui.mall.repository.model.User;
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
public interface UserConverter {

    List<UserVO> toVo(List<User> entityList);

    User createDtoToEntity(CreateUserDTO dto);

    User modifyDtoToEntity(ModifyUserDTO dto);
}
