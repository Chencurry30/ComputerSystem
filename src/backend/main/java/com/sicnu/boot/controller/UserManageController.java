package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserManageService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;
import com.sicnu.boot.vo.UserVo;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/27 10:37
 */
@RestController
@RequestMapping("/admin/users")
@Validated
public class UserManageController {
    @Resource
    private UserManageService userManageService;

    /**
     * description: 管理员登录
     *
     * @param user:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 21:03
     */
    @PostMapping("/login")
    ServerResponse<Map<String, Object>> login(@Valid @RequestBody User user){
        return userManageService.login(user);
    }

    /**
     * description: 退出登录接口，需要请求头携带token
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/9/28 22:08
     */
    @PostMapping("/logout")
    public ServerResponse<String> logout(){
        return userManageService.logout();
    }

    /**
     * description: 获取用户列表
     *
     * @param nickname:
     * @param pageNum:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:48
     */
    @GetMapping("/pages/{pageNum}")
    ServerResponse<PageInfo<UserDetail>> getUserList(@Length(max = 10,message = "昵称最长为10") String nickname,
                   @Min (value = 1,message = "分页数最小为1")@PathVariable Integer pageNum){
        return userManageService.getUserList(nickname,pageNum);
    }

    /**
     * description: 通过用户id，获取用户信息
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:48
     */
    @GetMapping("/{userId}")
    ServerResponse<UserDetail> getUserByUserId(@Min(value = 1,message = "userId最小为1")
                                               @PathVariable Integer userId){
        return userManageService.getUserByUserId(userId);
    }

    /**
     * description: 通过用户id，删除用户信息及其对应的角色
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:50
     */
    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAuthority('system:user:delete')")
    ServerResponse<String> deleteUserByUserId(@Min(value = 1,message = "userId最小为1")
                                              @PathVariable Integer userId){
        return userManageService.deleteUserByUserId(userId);
    }

    /**
     * description: 添加用户，并插入一条默认的角色student
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:51
     */
    @PostMapping()
    @PreAuthorize("hasAuthority('system:user:add')")
    ServerResponse<String> insertUser(@Validated(Insert.class) @RequestBody UserDetail userDetail){
        return userManageService.insertUser(userDetail);
    }

    /**
     * description: 更新用户角色
     *
     * @param userVo:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 18:59
     */
    @PutMapping("/role")
    @PreAuthorize("hasAuthority('system:user:update')")
    ServerResponse<String> updateUserRole(@Validated @RequestBody UserVo userVo){
        return userManageService.updateUserRole(userVo);
    }

    /**
     * description: 更新用户信息
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 19:00
     */
    @PutMapping()
    @PreAuthorize("hasAuthority('system:user:update')")
    ServerResponse<String> updateUser(@Validated(Update.class) @RequestBody UserDetail userDetail){
        return userManageService.updateUser(userDetail);
    }

    /**
     * description: 获取用户所有角色
     *
     * @param userId:
     * @return ServerResponse<List<Role>>
     * @author 胡建华
     * Date:  2022/11/1 21:51
     */
    @GetMapping("/role/{userId}")
    @PreAuthorize("hasAuthority('system:role:view')")
    ServerResponse<List<Role>> getUserRoleByUserId(@Min(value = 1,message = "userId最小为1")
                                       @PathVariable Integer userId){
        return userManageService.getUserRoleByUserId(userId);
    }

}
