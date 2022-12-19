package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.RoleMapper;
import com.sicnu.boot.mapper.UserManageMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.Role;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserManageService;
import com.sicnu.boot.service.UserService;
import com.sicnu.boot.utils.*;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.vo.UserDetail;
import com.sicnu.boot.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private RedisUtils redisUtils;

    @Override
    @SysLogAnnotation(operModel = "用户管理",operType = "登录",operDesc = "管理员登录后台系统")
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
    @SysLogAnnotation(operModel = "用户管理",operType = "注销",operDesc = "管理员退出登录后台")
    public ServerResponse<String> logout() {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userid = loginUser.getUser().getUserId();
        //删除redis的值
        redisUtils.deleteObject("login:"+userid);
        return ServerResponse.createBySuccessMessage("退出成功");
    }

    @Override
    public ServerResponse<PageInfo<UserDetail>> getUserList(String nickname, Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<UserDetail> list = userManageMapper.getUserList(nickname);
        for (UserDetail userDetail : list) {
            List<Role> roleList = userManageMapper.getRoleListByUserId(userDetail.getUserId());
            userDetail.setRoles(roleList);
            if (!roleList.isEmpty()){
                userDetail.setRoleOne(roleList.get(0));
            }
        }
        PageInfo<UserDetail> pageInfo = new PageInfo<>(list);
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<UserDetail> getUserByUserId(Integer userId) {
        UserDetail userDetail = userManageMapper.getUserByUserId(userId);
        return ServerResponse.createBySuccess("获取成功",userDetail);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SysLogAnnotation(operModel = "用户管理",operType = "删除",operDesc = "删除指定用户")
    public ServerResponse<String> deleteUserByUserId(Integer userId) {
        //删除用户对应的角色
        userManageMapper.deleteUserRole(userId);
        //删除用户
        userManageMapper.deleteUserByUserId(userId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SysLogAnnotation(operModel = "用户管理",operType = "插入",operDesc = "插入一条用户记录")
    public ServerResponse<String> insertUser(UserDetail userDetail) {
        //查看是否存在改用户名
        Integer checkUsername = userMapper.checkUsername(userDetail.getUsername());
        if (checkUsername > 0){
            log.error("插入用户时，插入失败，失败原因：用户名重复");
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USERNAME_REPEAT.getCode(),
                    "用户名重复，请重新添加");
        }
        //插入用户,默认密码为123456A
        String password = "123456A";
        userDetail.setPassword(passwordEncoder.encode(password));
        userManageMapper.insertUser(userDetail);
        //插入用户权限，默认student
        int roleId = roleMapper.selectRoleIdByRoleKey("student");
        userManageMapper.insertUserRole(userDetail.getUserId(),roleId);
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @SysLogAnnotation(operModel = "用户管理",operType = "更新",operDesc = "更新用户的角色信息")
    public ServerResponse<String> updateUserRole(UserVo userVo) {
        //查询改用户是否存在
        User user = userMapper.getUserById(userVo.getUserId());
        if (Objects.isNull(user)){
            log.error("更新用户角色时，更新失败，失败原因：更新的用户不存在");
            return ServerResponse.createByErrorMessage("该用户不存在");
        }
        //删除改用户的所有角色
        userManageMapper.deleteUserRole(userVo.getUserId());
        //为该用户添加角色
        for (Role role : userVo.getRoleList()) {
            //检查该角色是否存在
            int checkRoleByRoleId = roleMapper.checkRoleByRoleId(role.getRoleId());
            if (checkRoleByRoleId < 1){
                //如果该角色不存在，说明前端可能把角色传错误了，需要回滚
                log.error("更新用户角色时，更新失败，失败原因：前端传入非法角色，角色id：{}",role.getRoleId());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return ServerResponse.createByErrorMessage("传入后端的权限发生了错误");
            }
            //添加角色
            userManageMapper.insertUserRole(userVo.getUserId(),role.getRoleId());
        }
        return ServerResponse.createBySuccessMessage("修改成功");
    }

    @Override
    public ServerResponse<String> updateUser(UserDetail userDetail) {
        userManageMapper.updateUser(userDetail);
        return ServerResponse.createBySuccessMessage("修改成功");
    }

    @Override
    public ServerResponse<List<Role>> getUserRoleByUserId(Integer userId) {
        List<Role> list = userManageMapper.getRoleListByUserId(userId);
        return ServerResponse.createBySuccess("获取成功",list);
    }
}
