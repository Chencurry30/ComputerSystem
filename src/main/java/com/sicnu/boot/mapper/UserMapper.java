package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.User;
import org.apache.ibatis.annotations.Mapper;

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
     * @return User
     * @author hjh
     * @description 取出对应username的用户名的用户
     * @date 2022/9/10 11:44
     */
    User getByUsername(String username);

    /**
     * @param username:
     * @return Integer
     * @author hjh
     * @description 检查用户名是否存在
     * @date 2022/9/10 11:44
     */
    Integer checkUsername(String username);

    /**
     * @param username:
     * @param password:
     * @return Integer
     * @author hjh
     * @description 通过账户和密码进行注册，返回一个插入行数
     * @date 2022/9/11 9:28
     */
    Integer register(String username,String password);

    /**
     * @param phone: 
     * @return Integer
     * @author hjh
     * @description 检查手机号是否存在
     * @date 2022/9/11 15:14
     */
    Integer checkPhone(String phone);
}
