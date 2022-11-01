package com.sicnu.boot.controller;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserManageService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
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
    ServerResponse<String> insertUser(@Validated(Insert.class) @RequestBody UserDetail userDetail){
        return userManageService.insertUser(userDetail);
    }


}
