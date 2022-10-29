package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.MenuMapper;
import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.service.MenuService;
import com.sicnu.boot.utils.ServerResponse;
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

    @Override
    public ServerResponse<List<Menu>> getMenuTree() {
        //获取所有的权限列表
        List<Menu> menus = menuMapper.getMenuList();
        List<Menu> menuTree = new ArrayList<>();
        menus.forEach(menu -> {
            // 判断是否为顶层节点
            if (menu.getLevel() == 1) {
                // 获取子节点
                menu.setChildren(this.getChildTree(menu.getMenuId(), menus));
                menuTree.add(menu);
            }
        });
        return ServerResponse.createBySuccess("获取成功",menuTree);
    }

    private List<Menu> getChildTree(Integer id, List<Menu> menuList) {
        List<Menu> childList = new ArrayList<>();
        // 循环获取子节点
        menuList.forEach(menu -> {
            if (menu.getParentId() != null){
                if (menu.getParentId().equals(id) && menu.getLevel() > 1) {
                    childList.add(menu);
                }
            }
        });
        // 获取子节点的子节点
        childList.forEach(menu -> {
            // 递归获取子节点
            List<Menu> childTree = this.getChildTree(menu.getMenuId(), menuList);
            if (childTree.size() > 0) {
                menu.setChildren(childTree);
            }
        });
        return childList;
    }
}
