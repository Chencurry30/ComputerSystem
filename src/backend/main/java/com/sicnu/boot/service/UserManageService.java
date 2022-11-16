package com.sicnu.boot.service;

import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.UserDetail;
import com.sicnu.boot.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/28 11:44
 */
public interface UserManageService {
    /**
     * description: 管理员登录
     *
     * @param user:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/29 21:04
     */
    ServerResponse<Map<String, Object>> login(User user);

    /**
     * description: 退出登录
     *
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/16 15:39
     */
    ServerResponse<String> logout();

    /**
     * description: 通过nickname进行模糊查询，获取用户列表
     *
     * @param nickname:
     * @param pageNum: 分页数
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:42
     */
    ServerResponse<PageInfo<UserDetail>> getUserList(String nickname, Integer pageNum);

    /**
     * description: 通过用户id，获取用户信息
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:44
     */
    ServerResponse<UserDetail> getUserByUserId(Integer userId);

    /**
     * description: 通过用户id，删除用户信息及其对应的角色
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:45
     */
    ServerResponse<String> deleteUserByUserId(Integer userId);

    /**
     * description: 添加用户信息
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/30 9:46
     */
    ServerResponse<String> insertUser(UserDetail userDetail);

    /**
     * description: 更新用户角色
     *
     * @param userVo:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 19:14
     */
    ServerResponse<String> updateUserRole(UserVo userVo);

    /**
     * description: 更新用户信息
     *
     * @param userDetail:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 19:56
     */
    ServerResponse<String> updateUser(UserDetail userDetail);

    /**
     * description: 通过用户id，获取角色列表
     *
     * @param userId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/1 21:21
     */
    ServerResponse<List<Role>> getUserRoleByUserId(Integer userId);
}
