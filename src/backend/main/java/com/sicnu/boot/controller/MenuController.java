package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.service.MenuService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 9:48
 */
@RestController
@RequestMapping("/admin/menus")
public class MenuController {
    @Resource
    private MenuService menuService;

    /**
     * description: 获取所有的权限树
     *
     * @return ServerResponse<List<Menu>>
     * @author 胡建华
     * Date:  2022/10/27 19:23
     */
    @GetMapping("/tree")
    ServerResponse<List<Menu>> getMenuTree(){
        return menuService.getMenuTree();
    }

    /**
     * description: 添加一级权限
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:06
     */
    @PostMapping("/one")
    ServerResponse<String> insertOneMenu(Menu menu){
        return menuService.insertOneMenu(menu);
    }

    /**
     * description: 添加子权限
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:06
     */
    @PostMapping("/children")
    ServerResponse<String> insertChildrenMenu(Menu menu){
        return menuService.insertChildrenMenu(menu);
    }

    /**
     * description: 更新权限
     *
     * @param menu:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:25
     */
    @PutMapping
    ServerResponse<String> updateMenu(Menu menu){
        return menuService.updateMenu(menu);
    }

    /**
     * description: 删除权限
     *
     * @param menuId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:32
     */
    @DeleteMapping("/{menuId}")
    ServerResponse<String> deleteMenuByMenuId(@PathVariable Integer menuId){
        return menuService.deleteMenuByMenuId(menuId);
    }
}
