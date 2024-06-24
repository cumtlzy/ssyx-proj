package com.atguigu.ssyx.acl.service.impl;

import com.atguigu.ssyx.acl.mapper.PermissionMapper;
import com.atguigu.ssyx.acl.service.PermissionService;
import com.atguigu.ssyx.acl.service.RolePermissionService;
import com.atguigu.ssyx.acl.utils.PermissionHelper;
import com.atguigu.ssyx.model.acl.Permission;
import com.atguigu.ssyx.model.acl.RolePermission;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * ClassName: PermissionServiceImpl
 * Package: com.atguigu.ssyx.acl.service.impl
 */

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

    @Autowired
    private RolePermissionService permissionService;
    //获取所有菜单
    @Override
    public List<Permission> queryAllMenu() {
        //获取全部权限数据
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));

        //把权限数据构建成树形结构数据
        List<Permission> result = PermissionHelper.bulid(allPermissionList);
        return result;
    }

    //递归删除菜单
    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id, idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
        return true;
    }

    /**
     *	递归获取子节点
     * @param id
     * @param idList
     */
    private void selectChildListById(Long id, List<Long> idList) {
        List<Permission> childList = baseMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.stream().forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }

    /**
     * 分配菜单
     * @param roleId
     * @param permissionIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveRolePermissionRealtionShip(Long roleId, Long[] permissionIds){
        //删除用户分配的角色数据
        permissionService.remove(new QueryWrapper<RolePermission>().eq("role_id", roleId));

        //分配新的角色
        List<RolePermission> rolePermissionList = new ArrayList<>();
        for(Long permissionId : permissionIds) {
            if(StringUtils.isEmpty(roleId)) continue;
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            rolePermissionList.add(rolePermission);
        }
        permissionService.saveBatch(rolePermissionList);
    }

    /**
     * 根据用户获取菜单数据
     * @param roleId
     * @return
     */
    @Override
    public Map<String, Object> findPermissionByRoleId(Long roleId) {
        //查询所有的角色
        List<Permission> allPermissionList =queryAllMenu();
        List<Permission> assignPermission1 =baseMapper.selectList(null);

        //拥有的角色id
        List<RolePermission> existRolePermissionList = permissionService.list(new QueryWrapper<RolePermission>().eq("role_id", roleId).select("permission_id"));
        List<Long> existPermissionList = existRolePermissionList.stream().map(c->c.getPermissionId()).collect(Collectors.toList());

        //对角色进行分类
        List<Permission> assignPermission2 = new ArrayList<Permission>();
        for (Permission permission : assignPermission1) {
            //已分配
            if(existPermissionList.contains(permission.getId())) {
                assignPermission2.add(permission);
            }
        }
        List<Long> assignPermission = assignPermission2.stream().map(c->c.getId()).collect(Collectors.toList());

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignPermission", assignPermission);
        roleMap.put("allPermissionList", allPermissionList);
        return roleMap;
    }

}
