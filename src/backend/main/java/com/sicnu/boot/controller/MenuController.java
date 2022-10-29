package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.service.MenuService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
