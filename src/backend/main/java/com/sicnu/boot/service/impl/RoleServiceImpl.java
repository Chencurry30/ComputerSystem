package com.sicnu.boot.service.impl;

import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.MenuMapper;
import com.sicnu.boot.mapper.RoleMapper;
import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.service.RoleService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.TreeUtils;
import com.sicnu.boot.vo.RoleVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 11:22
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleMapper roleMapper;

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private TreeUtils treeUtils;

    @Override
    public ServerResponse<List<Menu>> getMenuListByRoleId(Integer roleId) {
        List<Menu> list = roleMapper.getMenuListByRoleId(roleId);
        return ServerResponse.createBySuccess("返回成功",list);
    }

    @Override
    public ServerResponse<List<Role>> getRoleList() {
        List<Role> list = roleMapper.getRoleList();
        return ServerResponse.createBySuccess("返回成功",list);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    @SysLogAnnotation(operModel = "角色管理",operType = "更新",operDesc = "更新角色所具有的权限")
    public ServerResponse<String> updateRoleMenu(RoleVo roleVo) {
        //查询改角色是否存在
        int count = roleMapper.checkRoleByRoleId(roleVo.getRoleId());
        if (count < 1){
            return ServerResponse.createByErrorMessage("该角色不存在");
        }
        //删除改角色的所有权限
        roleMapper.deleteRoleMenuByRoleId(roleVo.getRoleId());
        //为该角色添加权限
        for (Menu menu : roleVo.getMenuList()) {
            //检查该权限是否存在
            int checkMenuByMenuId = menuMapper.checkMenuByMenuId(menu.getMenuId());
            if (checkMenuByMenuId < 1){
                //如果该权限不存在，说明前端可能把权限传错误了，需要回滚
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ServerResponse.createByErrorMessage("传入后端的权限发生了错误");
            }
            //添加权限
            roleMapper.insertRoleMenu(roleVo.getRoleId(),menu.getMenuId());
        }
        return ServerResponse.createBySuccess("修改成功");
    }

    @Override
    @SysLogAnnotation(operModel = "角色管理",operType = "添加",operDesc = "添加一个角色")
    public ServerResponse<String> addRole(Role role) {
        roleMapper.insertRole(role);
        return ServerResponse.createBySuccess("添加成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SysLogAnnotation(operModel = "角色管理",operType = "删除",operDesc = "删除指定角色")
    public ServerResponse<String> deleteRoleByRoleId(Integer roleId) {
        //查看是否有用户拥有改角色
        int checkUserHasTheRole = roleMapper.checkUserHasTheRole(roleId);
        if (checkUserHasTheRole > 0){
            return ServerResponse.createByErrorMessage("无法删除该角色，该角色已经被分配给用户，请取消分配再删除");
        }
        //删除该角色的所有权限
        roleMapper.deleteRoleMenuByRoleId(roleId);
        //删除该角色的所有用户
        roleMapper.deleteUserRoleByRoleId(roleId);
        //删除该角色
        roleMapper.deleteRoleByRoleId(roleId);
        return ServerResponse.createBySuccess("删除成功");
    }

    @Override
    @SysLogAnnotation(operModel = "角色管理",operType = "更新",operDesc = "更新指定角色")
    public ServerResponse<String> updateRole(Role role) {
        roleMapper.updateRole(role);
        return ServerResponse.createBySuccess("更新成功");
    }


}
