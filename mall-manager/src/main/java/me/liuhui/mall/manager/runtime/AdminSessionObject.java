package me.liuhui.mall.manager.runtime;

import lombok.Data;

/**
 * Created on 2020/10/23 11:27
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class AdminSessionObject {
    private Long adminId;
    private String username;
    private String realName;
}
