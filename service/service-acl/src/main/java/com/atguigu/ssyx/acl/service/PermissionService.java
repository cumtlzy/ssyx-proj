package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * ClassName: PermissionService
 * Package: com.atguigu.ssyx.acl.service
 */

public interface PermissionService extends IService<Permission> {

    //获取所有菜单列表
    List<Permission> queryAllMenu();

    //递归删除
    boolean removeChildById(Long id);
}
