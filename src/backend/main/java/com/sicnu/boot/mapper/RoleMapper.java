package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 10:42
 */
@Mapper
public interface RoleMapper {
    /**
     * description: 通过角色id获取该角色的权限
     *
     * @param roleId:
     * @return List<Menu>
     * @author 胡建华
     * Date:  2022/10/27 10:44
     */
    List<Menu> getMenuListByRoleId(Integer roleId);

    /**
     * description: 获取角色列表
     *
     * @return List<Role>
     * @author 胡建华
     * Date:  2022/10/27 19:51
     */
    List<Role> getRoleList();

    /**
     * description: 检查用户是否拥有改角色
     *
     * @param roleId:
     * @return int
     * @author 胡建华
     * Date:  2022/11/5 9:25
     */
    int checkUserHasTheRole(Integer roleId);

    /**
     * description: 添加角色
     *
     * @param role:
     * @author 胡建华
     * Date:  2022/10/27 21:39
     */
    void insertRole(Role role);

    /**
     * description: 修改角色信息
     *
     * @param role:
     * @author 胡建华
     * Date:  2022/10/27 22:15
     */
    void updateRole(Role role);

    /**
     * description: 通过角色id，删除角色
     *
     * @param roleId:
     * @author 胡建华
     * Date:  2022/10/27 22:17
     */
    void deleteRoleByRoleId(Integer roleId);

    /**
     * description: 通过角色id，删除一个角色的全部权限
     *
     * @param roleId:
     * @author 胡建华
     * Date:  2022/10/28 22:12
     */
    void deleteRoleMenuByRoleId(Integer roleId);

    /**
     * description: 检查一个角色是否存在
     *
     * @param roleId:
     * @return int
     * @author 胡建华
     * Date:  2022/10/28 22:14
     */
    int checkRoleByRoleId(Integer roleId);

    /**
     * description: 插入用户权限
     *
     * @param roleId:
     * @param menuId:
     * @author 胡建华
     * Date:  2022/10/28 22:37
     */
    void insertRoleMenu(Integer roleId,Integer menuId);

    /**
     * description: 通过roleKey查找角色id
     *
     * @param roleKey:
     * @return int
     * @author 胡建华
     * Date:  2022/11/1 19:41
     */
    int selectRoleIdByRoleKey(String roleKey);

    /**
     * description: 通过角色id，删除用户角色关联
     *
     * @param roleId:
     * @author 胡建华
     * Date:  2022/11/1 20:33
     */
    void deleteUserRoleByRoleId(Integer roleId);


}
