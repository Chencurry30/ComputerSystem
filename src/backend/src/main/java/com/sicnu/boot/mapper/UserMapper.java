package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @projectName: computer-system
 * @package: com.sicnu.boot.mapper
 * @className: UserMapper
 * @author: hjh
 * @description: TODO
 * @date: 2022-09-09 20:49
 * @version:
 */
@Mapper
public interface UserMapper {
    /**
     * @param username:
     * @param password:
     * @return User
     * @author hjh
     * @description 通过用户名和密码登录
     * @date 2022/9/10 11:44
     */
    User login(String username, String password);

    /**
     * @param username:
     * @return Integer
     * @author hjh
     * @description 检查用户名是否存在
     * @date 2022/9/10 11:44
     */
    Integer checkUsername(String username);
}
