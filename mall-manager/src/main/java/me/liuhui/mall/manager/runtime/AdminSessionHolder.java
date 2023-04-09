package me.liuhui.mall.manager.runtime;

import me.liuhui.mall.manager.service.PermissionService;
import me.liuhui.mall.manager.service.vo.auth.AuthVO;
import me.liuhui.mall.repository.model.Permission;
import me.liuhui.mall.tools.utils.SpringContextUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created on 2020/10/14 18:04
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */
public class AdminSessionHolder {


    public static AuthVO getCurrentAdmin() {
        return (AuthVO) getSession().getAttribute("currentAdmin");
    }

    public static void setCurrentAdmin(AuthVO authVO) {
        getSession().setAttribute("currentAdmin", authVO);
    }

    @SuppressWarnings("unchecked")
    public static List<Permission> getPermission() {
        List<Permission> permissions = (List<Permission>) getSession().getAttribute("Permissions");
        if (permissions == null) {
            PermissionService bean = SpringContextUtil.getBean(PermissionService.class);
            permissions = bean.currentPermissions();
            if (permissions != null) {
                getSession().setAttribute("Permissions", permissions);
            }
        }
        return permissions;
    }


    private static HttpSession getSession() {
        return ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession (true);
    }


}
