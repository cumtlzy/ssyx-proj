package com.atguigu.ssyx.acl.service;

import com.atguigu.ssyx.model.acl.Role;
import com.atguigu.ssyx.vo.acl.RoleQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * ClassName: RoleService
 * Package: com.atguigu.ssyx.acl.service
 */
public interface RoleService extends IService<Role> {

    //角色分页列表
    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo);

}
