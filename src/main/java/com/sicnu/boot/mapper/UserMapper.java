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

    User login(String username, String password);
}
