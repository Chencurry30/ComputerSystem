package com.sicnu.boot.service.impl;

import com.sicnu.boot.service.ISmsService;
import com.sicnu.boot.utils.*;
import com.sicnu.boot.vo.LoginUser;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.UserService;
import com.sicnu.boot.vo.UpdateUser;
import com.sicnu.boot.vo.UserDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:
 * @author :     胡建华
 * Data: 2022-09-09 20:26
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisUtils redisUtils;

    @Resource
    private ISmsService smsService;

    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{6,12}$");

    @Override
    public ServerResponse<Map<String,Object>> login(User user) {
        if (StringUtils.isBlank(user.getUuId())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "参数非法");
        }
        //从redis中获取私钥
        String privateKey = redisUtils.getCacheObject(user.getUuId() + ":privateKey");
        if (StringUtils.isBlank(privateKey)){
            return ServerResponse.createByErrorMessage("密钥已经失效");
        }
        //解密密码
        user.setPassword(RSAUtils.decryptDataOnJava(user.getPassword(),privateKey));
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //认证失败，抛出异常
        if(Objects.isNull(authenticate)){
            log.error("用户名或密码错误");
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USERNAME_OR_PASSWORD_ERROR.getCode(), "用户名或密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getUserId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis,失效时间为30分钟
        redisUtils.setCacheObject("login:"+userId,loginUser,30, TimeUnit.MINUTES);
        //把token响应给前端
        HashMap<String,Object> map = new HashMap<>(5);
        map.put("token",jwt);
        //返回用户部分信息
        UserDetail userDetail = new UserDetail(loginUser.getUser().getNickname(),loginUser.getUser().getImage());
        map.put("user",userDetail);
        return ServerResponse.createBySuccess("登录成功",map);
    }

    @Override
    public ServerResponse<String> register(User user) {
        if (StringUtils.isBlank(user.getUuId())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "参数非法");
        }
        //从redis中获取私钥
        String privateKey = redisUtils.getCacheObject(user.getUuId() + ":privateKey");
        if (StringUtils.isBlank(privateKey)){
            return ServerResponse.createByErrorMessage("密钥已经失效");
        }
        //解密密码
        user.setPassword(RSAUtils.decryptDataOnJava(user.getPassword(),privateKey));
        //验证密码是否符合规范
        Matcher matcher = PASSWORD_PATTERN.matcher(user.getPassword());
        boolean matches = matcher.matches();
        if (!matches){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "密码不符合规范");
        }
        //检查手机号是否存在
        Integer checkPhone = userMapper.checkPhone(user.getPhone());
        if (checkPhone == 1){
            log.error("手机号已存在，请重新注册");
            return ServerResponse.createByErrorCodeMessage(ResponseCode.PHONE_REPEAT.getCode(), "手机号已存在，请重新注册");
        }
        //首先判断用户名是否存在
        Integer checkUsername = userMapper.checkUsername(user.getUsername());
        if(checkUsername == 1){
            log.error("用户名已经存在，请重新注册");
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USERNAME_REPEAT.getCode(), "用户名已经存在，请重新注册");
        }
        //验证手机验证码是否正确
        ServerResponse<String> verifySmsCode = verifySmsCode(user.getPhone(), user.getSmsCode());
        if (verifySmsCode.getCode() == ResponseCode.SMS_CODE_ERROR.getCode()){
            return verifySmsCode;
        }
        //对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //返回数据库受影响的行数
        Integer affectRow = userMapper.register(user);
        if (affectRow == 0){
            return ServerResponse.createByErrorMessage("注册失败，请重新注册");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    @Override
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
    public ServerResponse<UserDetail> getUserDetail() {
        //获取SecurityContextHolder中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        User user = loginUser.getUser();
        UserDetail userDetail = new UserDetail(user);
        return ServerResponse.createBySuccess("返回成功",userDetail);
    }

    @Override
    public ServerResponse<UserDetail> updateUserDetail(UserDetail userDetail) {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userid = loginUser.getUser().getUserId();
        User user = new User(userid, userDetail);
        userMapper.updateUser(user);
        //重新查询用户信息
        User userById = userMapper.getUserById(userid);
        loginUser.setUser(userById);
        //更新redis信息
        redisUtils.setCacheObject("login:"+userid , loginUser,30,TimeUnit.MINUTES);
        UserDetail userDetails = new UserDetail(userById);
        return ServerResponse.createBySuccess("更新成功",userDetails);
    }

    @Override
    public ServerResponse<String> forgetPassword(User user) {
        if (StringUtils.isBlank(user.getUuId())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "参数非法");
        }
        //从redis中获取私钥
        String privateKey = redisUtils.getCacheObject(user.getUuId() + ":privateKey");
        if (StringUtils.isBlank(privateKey)){
            return ServerResponse.createByErrorMessage("密钥已经失效");
        }
        //解密密码
        user.setPassword(RSAUtils.decryptDataOnJava(user.getPassword(),privateKey));
        //验证密码是否符合规范
        Matcher matcher = PASSWORD_PATTERN.matcher(user.getPassword());
        boolean matches = matcher.matches();
        if (!matches){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "密码不符合规范");
        }
        //验证是否存在此用户
        User byUsername = userMapper.getByUsername(user.getUsername());
        if (Objects.isNull(byUsername)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USER_NOT_FOUND.getCode(), "不存在此用户");
        }
        //验证手机验证码是否正确
        ServerResponse<String> verifySmsCode = verifySmsCode(user.getPhone(), user.getSmsCode());
        if (verifySmsCode.getCode() == ResponseCode.SMS_CODE_ERROR.getCode()){
            return verifySmsCode;
        }
        //对密码进行加密
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        //修改用户密码
        userMapper.updatePasswordByUsername(user.getUsername(),user.getPassword());
        return ServerResponse.createBySuccessMessage("修改成功");
    }

    @Override
    public ServerResponse<Map<String,String>> forgetUsername(UserDetail userDetail) {
        //验证手机验证码是否正确
        ServerResponse<String> verifySmsCode = verifySmsCode(userDetail.getPhone(), userDetail.getSmsCode());
        if (verifySmsCode.getCode() == ResponseCode.SMS_CODE_ERROR.getCode()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_ERROR.getCode(), "手机验证码错误");
        }
        String username = userMapper.getUsernameByPhone(userDetail.getPhone());
        Map<String,String> map = new HashMap<>(5);
        map.put("username",username);
        return ServerResponse.createBySuccess("获取成功",map);
    }

    @Override
    public ServerResponse<String> updatePhone(UpdateUser updateUser) {
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userid = loginUser.getUser().getUserId();
        //检查手机号是否已经存在
        Integer integer = userMapper.checkPhone(updateUser.getPhone());
        if (integer != 0){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.PHONE_REPEAT.getCode(), "手机号已经存在");
        }
        //验证旧手机号验证码
        ServerResponse<String> verifyCode = verifySmsCode(updateUser.getOldPhone(),updateUser.getOldSmsCode());
        if (verifyCode.getCode() == ResponseCode.SMS_CODE_ERROR.getCode()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_ERROR.getCode(),
                    "旧手机号的验证码错误");
        }
        //验证新手机号验证码
        ServerResponse<String> verifySmsCode = verifySmsCode(updateUser.getPhone(), updateUser.getSmsCode());
        if (verifySmsCode.getCode() == ResponseCode.SMS_CODE_ERROR.getCode()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_ERROR.getCode()
                    , "新手机号的验证码错误");
        }
        //修改手机号
        userMapper.updatePhoneByUserId(updateUser.getPhone(), userid);
        //更新redis信息
        loginUser.getUser().setPhone(updateUser.getPhone());
        redisUtils.setCacheObject("login:"+userid , loginUser,30,TimeUnit.MINUTES);
        return ServerResponse.createBySuccessMessage("手机号更改成功");
    }

    @Override
    public ServerResponse<String> updatePassword(UpdateUser updateUser) {
        if (StringUtils.isBlank(updateUser.getUuId())){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "参数非法");
        }
        //从redis中获取私钥
        String privateKey = redisUtils.getCacheObject(updateUser.getUuId() + ":privateKey");
        if (StringUtils.isBlank(privateKey)){
            return ServerResponse.createByErrorMessage("密钥已经失效");
        }
        //解密密码
        updateUser.setPassword(RSAUtils.decryptDataOnJava(updateUser.getPassword(),privateKey));
        updateUser.setOldPassword(RSAUtils.decryptDataOnJava(updateUser.getOldPassword(),privateKey));
        //验证密码是否符合规范
        Matcher matcher = PASSWORD_PATTERN.matcher(updateUser.getPassword());
        boolean matches = matcher.matches();
        if (!matches){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode()
                    , "密码不符合规范");
        }
        //获取SecurityContextHolder中的用户id
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userid = loginUser.getUser().getUserId();
        //验证旧密码是否正确
        boolean matches1 = passwordEncoder.matches(updateUser.getOldPassword(), userMapper.getPassword(userid));
        if (!matches1){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USERNAME_OR_PASSWORD_ERROR.getCode()
                    , "旧密码错误");
        }
        //验证手机验证码是否正确
        ServerResponse<String> verifySmsCode = verifySmsCode(updateUser.getPhone(), updateUser.getSmsCode());
        if (verifySmsCode.getCode() == ResponseCode.SMS_CODE_ERROR.getCode()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_ERROR.getCode()
                    , "手机号的验证码错误");
        }
        //修改密码
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        userMapper.updatePasswordByUserId(updateUser.getPassword(), userid);
        return ServerResponse.createBySuccessMessage("更改成功");
    }

    @Override
    public ServerResponse<Map<String,String>> getUserByUserId(Integer userId) {
        User user = userMapper.getUserById(userId);
        if (Objects.isNull(user)){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.USER_NOT_FOUND.getCode()
                    , "不存在此用户");
        }
        Map<String,String> map = new HashMap<>(10);
        map.put("nickname",user.getNickname());
        map.put("image",user.getImage());
        //判断该用户信息是否可见
        if (user.getIsHide() != 0){
            map.put("isHide","用户信息隐藏，不可见");
            return ServerResponse.createBySuccess("获取成功",map);
        }
        map.put("message",user.getMessage());
        map.put("sex",user.getSex());
        map.put("age",user.getAge().toString());
        return ServerResponse.createBySuccess("获取成功",map);
    }

    @Override
    public ServerResponse<String> getPublicKey(String uuId) {
        try {
            Map<String, Object> map;
            //生成密钥对
            map = RSAUtils.genKeyPair();
            //获取公钥和私钥
            String publicKey = RSAUtils.getPublicKey(map);
            String privateKey = RSAUtils.getPrivateKey(map);
            //将私钥存储到Redis,时限为5分钟
            redisUtils.setCacheObject(uuId + ":privateKey",privateKey,5,TimeUnit.MINUTES);
            //返回公钥
            return ServerResponse.createBySuccess("返回成功",publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ServerResponse.createByErrorCodeMessage(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), "服务器异常");
    }

    /**
     * description: 验证手机验证码是否正确
     *
     * @param phone:
     * @param smsCode:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/10/3 17:22
     */
    private ServerResponse<String> verifySmsCode(String phone,String smsCode){
        ServerResponse<String> verifyCodeResponse = smsService.verifyCode(phone, smsCode);
        if (verifyCodeResponse.getCode() != ResponseCode.SUCCESS.getCode()){
            log.error("验证码错误，请重新输入验证码");
            return ServerResponse.createByErrorCodeMessage(ResponseCode.SMS_CODE_ERROR.getCode(), "验证码错误，请重新输入验证码");
        }
        return ServerResponse.createBySuccess();
    }

}
