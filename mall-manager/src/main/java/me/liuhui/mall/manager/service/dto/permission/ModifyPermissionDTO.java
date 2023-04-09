package me.liuhui.mall.manager.service.dto.permission;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

/**
 * Created on 2020/10/15 18:36
 * <p>
 * Description: [TODO]
 * <p>
 * Company: []
 *
 * @author [清远]
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ModifyPermissionDTO extends CreatePermissionDTO {
    @NotNull
    private Long id;
}
