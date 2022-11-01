package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.RoleVo;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 11:22
 */
public interface RoleService {
    /**
     * description: 通过角色id获取权限列表
     *
     * @param roleId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/27 19:13
     */
    ServerResponse<List<Menu>> getMenuListByRoleId(Integer roleId);

    /**
     * description: 获取角色列表
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/27 19:51
     */
    ServerResponse<List<Role>> getRoleList();

    /**
     * description: 更新角色权限
     *
     * @param roleVo：
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/27 20:16
     */
    ServerResponse<String> updateRoleMenu(RoleVo roleVo);

    /**
     * description: 添加角色
     *
     * @param role:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/27 21:38
     */
    ServerResponse<String> addRole(Role role);

    /**
     * description: 通过id删除用户角色及其权限
     *
     * @param roleId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 15:53
     */
    ServerResponse<String> deleteRoleByRoleId(Integer roleId);

    /**
     * description: 更新角色信息
     *
     * @param role:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/1 20:20
     */
    ServerResponse<String> updateRole(Role role);
}
