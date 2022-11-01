package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/12 16:29
 */
@Mapper
public interface MenuMapper {
    /**
     * description: 获取所有的权限
     *
     * @return List<Menu>
     * @author 胡建华
     * Date:  2022/10/27 8:52
     */
    List<Menu> getMenuList();

    /**
     * description: 添加一级权限
     *
     * @param menu:
     * @author 胡建华
     * Date:  2022/10/27 22:31
     */
    void insertOneMenu(Menu menu);

    /**
     * description: 添加子权限
     *
     * @param menu:
     * @author 胡建华
     * Date:  2022/10/27 22:35
     */
    void insertChildrenMenu(Menu menu);

    /**
     * description: 修改菜单权限
     *
     * @param menu:
     * @author 胡建华
     * Date:  2022/10/27 22:37
     */
    void updateMenu(Menu menu);

    /**
     * description: 通过菜单id删除菜单
     *
     * @param menuId:
     * @author 胡建华
     * Date:  2022/10/27 22:39
     */
    void deleteMenuByMenuId(Integer menuId);

    /**
     * description: 通过menuId，检查权限是否存在
     *
     * @param menuId:
     * @return int
     * @author 胡建华
     * Date:  2022/10/29 9:04
     */
    int checkMenuByMenuId(Integer menuId);

    /**
     * description: 通过menuId，删除角色权限的关联
     *
     * @param menuId:
     * @author 胡建华
     * Date:  2022/11/1 20:38
     */
    void deleteRoleMenuByMenuId(Integer menuId);

    /**
     * description: 通过id获取权限
     *
     * @param menuId:
     * @return Menu
     * @author 胡建华
     * Date:  2022/11/1 23:00
     */
    Menu getMenuByMenuId(Integer menuId);

}
