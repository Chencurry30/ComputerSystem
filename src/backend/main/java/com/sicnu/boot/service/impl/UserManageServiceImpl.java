package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.UserManageMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserManageService;
import com.sicnu.boot.service.UserService;
import com.sicnu.boot.utils.*;
import com.sicnu.boot.vo.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/28 11:44
 */
@Service
@Slf4j
public class UserManageServiceImpl implements UserManageService {

    @Resource
    private UserService userService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserManageMapper userManageMapper;

    @Override
    public ServerResponse<Map<String, Object>> login(User user) {
        //验证用户是否具有管理员权限
        int checkAdmin = userManageMapper.checkAdmin(user.getUsername());
        if (checkAdmin < 1){
            log.error("权限不足，拒绝访问");
            return ServerResponse.createByErrorCodeMessage(ResponseCode.FORBIDDEN.getCode()
                    , "权限不足");
        }
        return userService.login(user);
    }

    @Override
    public ServerResponse<PageInfo<UserDetail>> getUserList(String nickname, Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<UserDetail> list = userManageMapper.getUserList(nickname);
        for (UserDetail userDetail : list) {
            List<Role> roleList = userManageMapper.getRoleListByUserId(userDetail.getUserId());
            userDetail.setRoles(roleList);
        }
        PageInfo<UserDetail> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<UserDetail> getUserByUserId(Integer userId) {
        UserDetail userDetail = userManageMapper.getUserByUserId(userId);
        return ServerResponse.createBySuccess("获取成功",userDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse<String> deleteUserByUserId(Integer userId) {
        //删除用户对应的角色
        userManageMapper.deleteUserRole(userId);
        //删除用户
        userManageMapper.deleteUserByUserId(userId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse<String> insertUser(UserDetail userDetail) {
        //查看是否存在改用户名
        Integer checkUsername = userMapper.checkUsername(userDetail.getUsername());
        if (checkUsername > 0){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USERNAME_REPEAT.getCode(),
                    "用户名重复，请重新添加");
        }
        //插入用户,默认密码为123456
        String password = "123456";
        userDetail.setPassword(passwordEncoder.encode(password));
        userManageMapper.insertUser(userDetail);
        //插入用户权限，默认student
        userManageMapper.insertUserRole(userDetail.getUserId());
        return ServerResponse.createBySuccess("添加成功");
    }
}
