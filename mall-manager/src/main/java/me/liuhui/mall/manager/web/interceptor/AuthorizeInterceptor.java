package me.liuhui.mall.manager.web.interceptor;

import com.alibaba.fastjson.JSONObject;
import me.liuhui.mall.common.base.enums.VoCodeEnum;
import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.runtime.AdminSessionHolder;
import me.liuhui.mall.manager.service.vo.auth.AuthVO;
import me.liuhui.mall.manager.utils.HttpUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;


/**
 * @author 清远
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return super.preHandle(request, response, handler);
        }
        MDC.put("ip", HttpUtil.getRemoteAddr(request));
        MDC.put("requestUri", request.getRequestURI());
        MDC.put("requestId", System.currentTimeMillis() + RandomStringUtils.randomAlphabetic(3));
        AuthVO admin = AdminSessionHolder.getCurrentAdmin();
        if (admin == null) {
            boolean isAjax = HttpUtil.isAjax(request);
            if (isAjax) {
                response.setContentType("application/json;charset=UTF-8");
                response.getWriter().print(JSONObject.toJSONString(ResultVO.buildResult(VoCodeEnum.NOT_LOGGED_IN)));
                return false;
            }
            String redirectUrl = request.getRequestURL().toString();
            if (request.getQueryString() != null) {
                redirectUrl += ("?" + request.getQueryString());
            }
            response.sendRedirect(request.getContextPath() + "/page/login.html?redirectUrl=" + URLEncoder.encode(redirectUrl, "utf-8"));
            return false;
        }
        MDC.put("user", admin.getUsername());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
        if (!(handler instanceof HandlerMethod)) {
            return;
        }
        MDC.clear();
    }
}
