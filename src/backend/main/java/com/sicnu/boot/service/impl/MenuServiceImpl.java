package com.sicnu.boot.service.impl;

import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.MenuMapper;
import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.service.MenuService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.TreeUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 9:17
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private TreeUtils treeUtils;

    @Override
    public ServerResponse<List<Menu>> getMenuTree() {
        //获取所有的权限列表
        List<Menu> menus = menuMapper.getMenuList();
        List<Menu> menuTree = new ArrayList<>();
        menus.forEach(menu -> {
            // 判断是否为顶层节点
            if (menu.getLevel() == 1) {
                // 获取子节点
                menu.setChildren(treeUtils.getChildTree(menu.getMenuId(), menus));
                menuTree.add(menu);
            }
        });
        return ServerResponse.createBySuccess("获取成功",menuTree);
    }

    @Override
    @SysLogAnnotation(operModel = "权限管理",operType = "添加",operDesc = "添加一个一级权限")
    public ServerResponse<String> insertOneMenu(Menu menu) {
        menuMapper.insertOneMenu(menu);
        return ServerResponse.createBySuccess("添加成功");
    }

    @Override
    @SysLogAnnotation(operModel = "权限管理",operType = "添加",operDesc = "添加一个子权限")
    public ServerResponse<String> insertChildrenMenu(Menu menu) {
        menuMapper.insertChildrenMenu(menu);
        return ServerResponse.createBySuccess("添加成功");
    }

    @Override
    @SysLogAnnotation(operModel = "权限管理",operType = "更新",operDesc = "更新指定权限")
    public ServerResponse<String> updateMenu(Menu menu) {
        menuMapper.updateMenu(menu);
        return ServerResponse.createBySuccess("更新成功");
    }

    @Override
    @SysLogAnnotation(operModel = "权限管理",operType = "删除",operDesc = "删除指定权限")
    public ServerResponse<String> deleteMenuByMenuId(Integer menuId) {
        //删除权限对应的角色
        menuMapper.deleteRoleMenuByMenuId(menuId);
        //删除权限
        menuMapper.deleteMenuByMenuId(menuId);
        return ServerResponse.createBySuccess("删除成功");
    }

    @Override
    public ServerResponse<Menu> getMenuByMenuId(Integer menuId) {
        Menu menu = menuMapper.getMenuByMenuId(menuId);
        return ServerResponse.createBySuccess("获取成功",menu);
    }


}
