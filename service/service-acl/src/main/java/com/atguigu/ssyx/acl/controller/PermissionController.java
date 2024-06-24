package com.atguigu.ssyx.acl.controller;

import com.atguigu.ssyx.acl.service.PermissionService;
import com.atguigu.ssyx.common.result.Result;
import com.atguigu.ssyx.model.acl.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ClassName: PermissionController
 * Package: com.atguigu.ssyx.acl.controller
 */

@RestController
@RequestMapping("/admin/acl/permission")
@Api(tags = "菜单管理")
@CrossOrigin //跨域
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @ApiOperation(value = "获取菜单")
    @GetMapping
    public Result index() {
        List<Permission> list = permissionService.queryAllMenu();
        return Result.ok(list);
    }

    @ApiOperation(value = "新增菜单")
    @PostMapping("save")
    public Result save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return Result.ok(null);
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("update")
    public Result updateById(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return Result.ok(null);
    }

    @ApiOperation(value = "递归删除菜单")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        permissionService.removeChildById(id);
        return Result.ok(null);
    }

    @ApiOperation(value = "根据角色获取菜单数据")
    @GetMapping("/toAssign/{roleId}")
    public Result toAssign(@PathVariable Long roleId) {
        Map<String, Object> roleMap = permissionService.findPermissionByRoleId(roleId);
        return Result.ok(roleMap);
    }

    @ApiOperation(value = "根据用户分配角色")
    @PostMapping("/doAssign")
    public Result doAssign(@RequestParam Long roleId,@RequestParam Long[] permissionId) {
        permissionService.saveRolePermissionRealtionShip(roleId,permissionId);
        return Result.ok(null);
    }
}
