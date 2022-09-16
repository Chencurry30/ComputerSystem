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
     * description: 检查用户名是否存在
     *
     * @param username: 用户名
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/10 11:44
     */
    Integer checkUsername(String username);

    /**
     * description: 通过账户和密码进行注册，返回一个插入行数
     *
     * @param username: 用户名
     * @param password: 密码
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/15 19:12
     */
    Integer register(String username,String password);

    /**
     * description: 检查手机号是否存在
     *
     * @param phone: 手机号
     * @return Integer
     * @author 胡建华
     * Date:  2022/9/15 19:12
     */
    Integer checkPhone(String phone);
}
