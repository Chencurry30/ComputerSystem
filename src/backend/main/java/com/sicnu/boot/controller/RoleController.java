package com.sicnu.boot.controller;

import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.service.RoleService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.RoleVo;
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
 * Data:    2022/10/27 19:32
 */
@RestController
@Validated
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
    @GetMapping("/menu/{roleId}")
    @PreAuthorize("hasAuthority('system:role:view')")
    ServerResponse<List<Menu>> getMenuListByRoleId(@Min(value = 1,message = "roleId最小值为1")
                                                   @PathVariable Integer roleId){
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
    @PreAuthorize("hasAuthority('system:role:view')")
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
    @PutMapping("/menu")
    @PreAuthorize("hasAuthority('system:role:getMenu')")
    ServerResponse<String> updateRoleMenu(@Validated @RequestBody RoleVo roleVo){
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
    @PreAuthorize("hasAuthority('system:role:add')")
    ServerResponse<String> addRole(@Validated(Insert.class) @RequestBody Role role){
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
    @PreAuthorize("hasAuthority('system:role:delete')")
    ServerResponse<String> deleteRoleByRoleId(@Min(value = 4,message = "角色id最小值为4")
                                              @PathVariable("roleId") Integer roleId){
        return roleService.deleteRoleByRoleId(roleId);
    }

    /**
     * description: 更新角色信息
     *
     * @param role:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 19:01
     */
    @PutMapping()
    @PreAuthorize("hasAuthority('system:role:update')")
    ServerResponse<String> updateRole(@Validated(Update.class) @RequestBody Role role){
        return roleService.updateRole(role);
    }
}
