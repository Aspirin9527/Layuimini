package me.liuhui.mall.manager.service.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created on 2020/10/23 14:49
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@Data
public class ModifyMyPasswordDTO {
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
}
