package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

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
     * description: 检查用户名是否存在
     *
     * @param username: 用户名
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/10 11:44
     */
    Integer checkUsername(String username);

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
}
