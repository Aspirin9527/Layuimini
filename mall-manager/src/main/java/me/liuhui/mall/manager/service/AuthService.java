package me.liuhui.mall.manager.service;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.dto.auth.LoginDTO;
import me.liuhui.mall.manager.service.vo.auth.AuthVO;

/**
 * Created on 2020/10/23 11:20
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
public interface AuthService {
    /**
     * 登录
     *
     * @param dto
     * @return
     */
    ResultVO<AuthVO> login(LoginDTO dto);
}
