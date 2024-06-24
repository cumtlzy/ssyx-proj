package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: PermissionService
 * Package: com.atguigu.ssyx.acl.service
 */

public interface PermissionService extends IService<Permission> {

    //获取所有菜单列表
    List<Permission> queryAllMenu();

    //递归删除
    boolean removeChildById(Long id);

    /**
     * 分配菜单
     */
    void saveRolePermissionRealtionShip(Long roleid, Long[] permissionIds);

    /**
     * 根据菜单获取权限数据
     */
    Map<String, Object> findPermissionByRoleId(Long roleId);
}
