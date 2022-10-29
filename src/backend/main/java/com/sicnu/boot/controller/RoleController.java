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

    @GetMapping("/{roleId}")
    ServerResponse<List<Menu>> getMenuListByRoleId(@PathVariable Integer roleId){
        return roleService.getMenuListByRoleId(roleId);
    }

    @GetMapping()
    ServerResponse<List<Role>> getRoleList(){
        return roleService.getRoleList();
    }

    @PutMapping
    ServerResponse<String> updateRoleMenu(@RequestBody RoleVo roleVo){
        return roleService.updateRoleMenu(roleVo);
    }

    @PostMapping()
    ServerResponse<String> addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
}
