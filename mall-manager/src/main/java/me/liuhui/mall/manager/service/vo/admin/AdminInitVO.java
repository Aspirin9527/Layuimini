package me.liuhui.mall.manager.service.vo.admin;

import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * Created on 2020/10/14 17:57
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */
@Data
public class AdminInitVO {
    private List<PermissionVO> menuInfo;
    private Set<String> perCodes;
    private String realName;
    private String frontDomain;
}
