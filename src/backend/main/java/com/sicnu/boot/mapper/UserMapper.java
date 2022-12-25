package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.vo.CommentUserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:49
 */
@Mapper
public interface UserMapper {
    /**
     * description: 取出对应username的用户名的用户
     *
     * @param username: 用户名
     * @return User
     * @author 胡建华
     * Date:  2022/9/15 19:11
     */
    User getByUsername(String username);

    /**
     * description: 通过id查询用户
     *
     * @param userId: 用户id
     * @return User
     * @author 胡建华
     * Date:  2022/9/30 17:21
     */
    User getUserById(Integer userId);

    /**
     * description: 通过用户id获取用户昵称，用户头像
     *
     * @param userId:
     * @return CommentUserVo
     * @author 胡建华
     * Date:  2022/10/19 22:57
     */
    CommentUserVo getCommentUserById(Integer userId);

    /**
     * description: 检查用户名是否存在
     *
     * @param username: 用户名
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/10 11:44
     */
    Integer checkUsername(String username);

    /**
     * description: 通过用户id获取用户昵称
     *
     * @param userId:
     * @return String
     * @author 胡建华
     * Date:  2022/10/16 15:58
     */
    String getNicknameByUserId(Integer userId);

    /**
     * description: 注册用户，需要用户名，密码和手机号
     *
     * @param user:用户
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/15 19:12
     */
    Integer register(User user);

    /**
     * description: 检查手机号是否存在
     *
     * @param phone: 手机号
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/15 19:12
     */
    Integer checkPhone(String phone);

    /**
     * description: 更新用户信息
     *
     * @param user: 用户
     * @return Integer ：返回修改行数
     * @author 胡建华
     * Date:  2022/9/30 16:40
     */
    Integer updateUser(User user);

    /**
     * description: 通过用户名修改密码
     *
     * @param username:
     * @param password:
     * @author 胡建华
     * Date:  2022/10/3 19:26
     */
    void updatePasswordByUsername(String username,String password);

    /**
     * description: 通过手机号获取用户名
     *
     * @param phone:
     * @return String
     * @author 胡建华
     * Date:  2022/10/3 19:27
     */
    String getUsernameByPhone(String phone);

    /**
     * description: 通过用户id修改手机号
     *
     * @param phone:
     * @param userId:
     * @author 胡建华
     * Date:  2022/10/4 9:25
     */
    void updatePhoneByUserId(String phone,Integer userId);

    /**
     * description: 通过用户id获取用户密码
     *
     * @param userId:
     * @return Integer
     * @author 胡建华
     * Date:  2022/10/4 9:25
     */
    String getPassword(Integer userId);

    /**
     * description: 通过用户id修改密码
     *
     * @param password:
     * @param userId:
     * @author 胡建华
     * Date:  2022/10/4 9:25
     */
    void updatePasswordByUserId(String password,Integer userId);

    /**
     * description: 通过用户id获取权限列表
     *
     * @param userId:
     * @return List<Menu>
     * @author 胡建华
     * Date:  2022/10/29 22:24
     */
    List<Menu> getUserMenu(Integer userId);

    /**
     * description: 判断一个用户是否为老师
     *
     * @param userId:
     * @return Integer
     * @author 胡建华
     * Date:  2022/12/25 15:55
     */
    Integer checkIsTeacher(Integer userId);
}
