package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.service.RoleService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.RoleVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 19:32
 */
@RestController
@RequestMapping("/admin/roles")
public class RoleController {
    @Resource
    private RoleService roleService;

    /**
     * description: 通过角色id获取权限列表
     *
     * @param roleId:
     * @return ServerResponse<List<Menu>>
     * @author 胡建华
     * Date:  2022/10/30 9:36
     */
    @GetMapping("/{roleId}")
    ServerResponse<List<Menu>> getMenuListByRoleId(@PathVariable Integer roleId){
        return roleService.getMenuListByRoleId(roleId);
    }

    /**
     * description: 获取角色列表
     *
     * @return ServerResponse<List<Role>>
     * @author 胡建华
     * Date:  2022/10/30 9:36
     */
    @GetMapping()
    ServerResponse<List<Role>> getRoleList(){
        return roleService.getRoleList();
    }

    /**
     * description: 更新角色权限
     *
     * @param roleVo:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/10/30 9:36
     */
    @PutMapping
    ServerResponse<String> updateRoleMenu(@RequestBody RoleVo roleVo){
        return roleService.updateRoleMenu(roleVo);
    }

    /**
     * description: 添加角色
     *
     * @param role:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/10/30 9:37
     */
    @PostMapping()
    ServerResponse<String> addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }

    /**
     * description: 通过角色id，删除角色及其对应的权限
     *
     * @param roleId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:37
     */
    @DeleteMapping("/{roleId}")
    ServerResponse<String> deleteRoleByRoleId(@PathVariable("roleId") Integer roleId){

        return roleService.deleteRoleByRoleId(roleId);
    }
}
