package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 9:17
 */
public interface MenuService {
    /**
     * description: 获取所有的权限树
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/27 9:21
     */
    ServerResponse<List<Menu>> getMenuTree();

    /**
     * description: 添加一级权限
     *
     * @param menu:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:14
     */
    ServerResponse<String> insertOneMenu(Menu menu);

    /**
     * description: 添加子权限
     *
     * @param menu:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:22
     */
    ServerResponse<String> insertChildrenMenu(Menu menu);

    /**
     * description: 更新权限
     *
     * @param menu:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:26
     */
    ServerResponse<String> updateMenu(Menu menu);

    /**
     * description: 通过menuId删除权限
     *
     * @param menuId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:32
     */
    ServerResponse<String> deleteMenuByMenuId(Integer menuId);

    /**
     * description: 通过id获取权限
     *
     * @param menuId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 22:59
     */
    ServerResponse<Menu> getMenuByMenuId(Integer menuId);
}
