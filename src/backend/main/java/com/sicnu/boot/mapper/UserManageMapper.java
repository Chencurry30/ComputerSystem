package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.vo.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/28 11:46
 */
@Mapper
public interface UserManageMapper {
    /**
     * description: 获取所有的用户列表,对昵称进行模糊查询
     *
     * @param nickname :
     * @return List<UserDetail>
     * @author 胡建华
     * Date:  2022/10/28 21:03
     */
    List<UserDetail> getUserList(String nickname);

    /**
     * description: 通过用户id获取用户信息
     *
     * @param userId:
     * @return UserDetail
     * @author 胡建华
     * Date:  2022/10/28 21:57
     */
    UserDetail getUserByUserId(Integer userId);

    /**
     * description: 通过用户id删除用户信息
     *
     * @param userId:
     * @author 胡建华
     * Date:  2022/10/28 21:57
     */
    void deleteUserByUserId(Integer userId);

    /**
     * description: 添加用户
     *
     * @param userDetail:
     * @author 胡建华
     * Date:  2022/10/28 22:04
     */
    void insertUser(UserDetail userDetail);

    /**
     * description: 检验用户是否为管理员
     *
     * @param username:
     * @return int
     * @author 胡建华
     * Date:  2022/10/29 23:17
     */
    int checkAdmin(String username);

    /**
     * description: 通过用户id，删除其具有的角色
     *
     * @param userId:
     * @author 胡建华
     * Date:  2022/10/30 10:02
     */
    void deleteUserRole(Integer userId);

    /**
     * description: 插入用户角色
     *
     * @param userId:
     * @param roleId:
     * @author 胡建华
     * Date:  2022/10/30 10:39
     */
    void insertUserRole(Integer userId,Integer roleId);

    /**
     * description: 通过用户id获取其角色列表
     *
     * @param userId:
     * @return List<Role>
     * @author 胡建华
     * Date:  2022/10/31 19:02
     */
    List<Role> getRoleListByUserId(Integer userId);

    /**
     * description: 更新用户信息
     *
     * @param userDetail:
     * @author 胡建华
     * Date:  2022/11/1 20:01
     */
    void updateUser(UserDetail userDetail);


}
