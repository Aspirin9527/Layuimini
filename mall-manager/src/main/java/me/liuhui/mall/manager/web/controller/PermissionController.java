package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.PermissionService;
import me.liuhui.mall.manager.service.dto.permission.CreatePermissionDTO;
import me.liuhui.mall.manager.service.dto.permission.ModifyPermissionDTO;
import me.liuhui.mall.manager.service.vo.admin.PermissionVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

/**
 * Created on 2020/10/15 12:51
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */
@Validated
@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @PerCode("permission:mgt")
    @GetMapping("list")
    public ResultVO<List<PermissionVO>> list() {
        return permissionService.list();
    }

    @GetMapping("tree")
    public ResultVO<List<PermissionVO>> tree() {
        return permissionService.permissionTree();
    }

    @PerCode("permission:add")
    @PostMapping("create")
    public ResultVO<Boolean> create(@Validated @RequestBody CreatePermissionDTO dto) {
        return permissionService.create(dto);
    }

    @PerCode("permission:update")
    @PostMapping("modify")
    public ResultVO<Boolean> modify(@Validated @RequestBody ModifyPermissionDTO dto) {
        return permissionService.modify(dto);
    }

    @PerCode("permission:del")
    @DeleteMapping("delete")
    public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> id) {
        return permissionService.delete(id);
    }
}
