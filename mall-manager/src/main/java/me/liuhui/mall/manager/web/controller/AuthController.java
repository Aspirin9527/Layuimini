package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.enums.VoCodeEnum;
import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.runtime.AdminSessionHolder;
import me.liuhui.mall.manager.service.AuthService;
import me.liuhui.mall.manager.service.dto.auth.LoginDTO;
import me.liuhui.mall.manager.service.vo.auth.AuthVO;
import com.wf.captcha.ArithmeticCaptcha;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created on 2020/10/23 11:05
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */

@RequestMapping("/api/auth")
@RestController
public class AuthController {

    @Resource
    private AuthService authService;

    @GetMapping("/captcha")
    public ResultVO<String> captcha(HttpSession session) {
        // 算术类型
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(97, 38);
        // 获取运算的结果
        String code = captcha.text();
        String img = captcha.toBase64();
        session.setAttribute("validCode", code);
        return new ResultVO<>(VoCodeEnum.SUCCESS, img);
    }

    @PostMapping("/login")
    public ResultVO<Boolean> login(@Validated @RequestBody LoginDTO dto) {
        ResultVO<AuthVO> resultVO = authService.login(dto);
        if (resultVO.isSuccess()) {
            AuthVO authVO = resultVO.getData();
            AdminSessionHolder.setCurrentAdmin(authVO);
            return ResultVO.buildSuccessResult();
        }
        return ResultVO.buildFailResult(resultVO.getMsg());
    }

    @GetMapping("/logout")
    public ResultVO<Boolean> logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResultVO.buildSuccessResult();
    }
}
