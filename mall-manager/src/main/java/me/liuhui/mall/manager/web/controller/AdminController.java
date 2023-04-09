package me.liuhui.mall.manager.web.controller;

import me.liuhui.mall.common.base.vo.ResultVO;
import me.liuhui.mall.manager.service.AdminService;
import me.liuhui.mall.manager.service.RoleService;
import me.liuhui.mall.manager.service.dto.admin.*;
import me.liuhui.mall.manager.service.dto.role.ListRoleDTO;
import me.liuhui.mall.manager.service.vo.admin.AdminInitVO;
import me.liuhui.mall.manager.service.vo.admin.AdminVO;
import me.liuhui.mall.manager.service.vo.admin.ListAdminLoginRecordVO;
import me.liuhui.mall.manager.service.vo.admin.ListAdminVO;
import me.liuhui.mall.manager.service.vo.role.ListRoleVO;
import me.liuhui.mall.manager.web.annotation.PerCode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created on 2020/10/14 17:09
 * <p>
 * Description: [TODO]
 * <p>
 *
 * @author [清远]
 */
@Validated
@RequestMapping("/api/admin")
@RestController
public class AdminController {

    @Resource
    private AdminService adminService;
    @Resource
    private RoleService roleService;

    @GetMapping("/init")
    public ResultVO<AdminInitVO> init() {
        return adminService.init();
    }

    @GetMapping("/welcome")
    public ResultVO<WelcomeVO> welcome() {
        return adminService.welcome();
    }


    @GetMapping("/info")
    public ResultVO<AdminVO> myInfo() {
        return adminService.myInfo();
    }

    @PostMapping("/modify-mine")
    public ResultVO<Boolean> myInfo(@Validated({AdminDTO.UpdateMine.class}) @RequestBody AdminDTO dto) {
        return adminService.modifyMyInfo(dto);
    }

    @PostMapping("/modify-my-password")
    public ResultVO<Boolean> modifyMyPassword(@Validated @RequestBody ModifyMyPasswordDTO dto) {
        return adminService.modifyMyPassword(dto);
    }


    @PerCode("admin:mgt")
    @GetMapping("list")
    public ResultVO<ListAdminVO> list(ListAdminDTO dto) {
        return adminService.list(dto);
    }

    @PerCode("admin:login-record")
    @GetMapping("list-login-record")
    public ResultVO<ListAdminLoginRecordVO> listLoginRecored(ListAdminLoginRecordDTO dto) {
        return adminService.listLoginRecored(dto);
    }

    @PerCode("admin:add")
    @PostMapping("create")
    public ResultVO<Boolean> create(@Validated({AdminDTO.Add.class}) @RequestBody AdminDTO dto) {
        return adminService.create(dto);
    }

    @PerCode("admin:update")
    @PostMapping("modify")
    public ResultVO<Boolean> modify(@Validated({AdminDTO.Update.class}) @RequestBody AdminDTO dto) {
        return adminService.modify(dto);
    }

    @PerCode("admin:status")
    @PostMapping("change-status")
    public ResultVO<Boolean> changeStatus(@Validated @RequestBody ChangeStatusDTO dto) {
        return adminService.changeStatus(dto);
    }

    @PerCode("admin:del")
    @DeleteMapping("delete")
    public ResultVO<Boolean> delete(@RequestBody @Validated @NotNull @Size(min = 1) Set<Long> ids) {
        return adminService.delete(ids);
    }


    @PerCode({"admin:add", "admin:update"})
    @GetMapping("select-role")
    public ResultVO<ListRoleVO> selectRole() {
        ListRoleDTO dto = new ListRoleDTO();
        dto.setPage(1);
        dto.setLimit(100);
        return roleService.list(dto);
    }
}
