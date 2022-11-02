package com.sicnu.boot.controller;

import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.service.MenuService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 9:48
 */
@Validated
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
    @PreAuthorize("hasAuthority('system:menu:view')")
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
    @PreAuthorize("hasAuthority('system:menu:insert')")
    ServerResponse<String> insertOneMenu(@Validated(Insert.class)
                                         @RequestBody Menu menu){
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
    @PreAuthorize("hasAuthority('system:menu:insert')")
    ServerResponse<String> insertChildrenMenu(@Validated(Insert.class)
                                              @RequestBody Menu menu){
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
    @PreAuthorize("hasAuthority('system:menu:update')")
    ServerResponse<String> updateMenu(@Validated(Update.class)
                                      @RequestBody Menu menu){
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
    @PreAuthorize("hasAuthority('system:menu:delete')")
    ServerResponse<String> deleteMenuByMenuId(@Min(value = 0,message = "id的最小值为1")
                                              @PathVariable Integer menuId){
        return menuService.deleteMenuByMenuId(menuId);
    }

    /**
     * description: 通过id获取权限
     *
     * @param menuId:
     * @return ServerResponse<Menu>
     * @author 胡建华
     * Date:  2022/11/2 15:32
     */
    @GetMapping("/{menuId}")
    @PreAuthorize("hasAuthority('system:menu:view')")
    ServerResponse<Menu> getMenuByMenuId(@Min(value = 0,message = "id的最小值为1")
                                   @PathVariable Integer menuId){
        return menuService.getMenuByMenuId(menuId);
    }
}
