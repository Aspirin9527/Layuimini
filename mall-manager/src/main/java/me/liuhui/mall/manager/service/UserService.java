package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.user.ChangeStatusDTO;
import me.liuhui.mall.manager.service.dto.user.ListUserDTO;
import me.liuhui.mall.manager.service.dto.user.ModifyUserDTO;
import me.liuhui.mall.manager.service.vo.user.ListUserVO;

import java.util.Set;


public interface UserService {


	ResultVO<Boolean> modify(ModifyUserDTO dto);

	ResultVO<Boolean> delete(Set<Long> ids);

	ResultVO<ListUserVO> list(ListUserDTO dto);


    ResultVO<Boolean> changeStatus(ChangeStatusDTO dto);

}
