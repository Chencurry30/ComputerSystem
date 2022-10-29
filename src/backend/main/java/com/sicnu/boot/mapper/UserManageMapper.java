package com.sicnu.boot.mapper;

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
     * @author 胡建华
     * Date:  2022/10/28 22:04
     */
    void insertUser();
}
