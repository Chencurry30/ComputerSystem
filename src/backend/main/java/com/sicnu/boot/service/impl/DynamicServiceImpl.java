package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.DynamicMapper;
import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.service.DynamicService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/26 14:28
 */
@Service
@Slf4j
public class DynamicServiceImpl implements DynamicService {
    @Resource
    private DynamicMapper dynamicMapper;

    @Override
    public ServerResponse<String> addDynamic(Dynamic dynamic) {
        //从redis中读取authorId，并设置
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        dynamic.setUserId(loginUser.getUser().getUserId());
        //设置评论时间
        dynamic.setCreateDate(LocalDateTime.now());
        dynamicMapper.addDynamic(dynamic);
        return ServerResponse.createBySuccess("创建成功");
    }

    @Override
    public ServerResponse<String> deleteDynamic(Integer dynamicId) {
        //从redis中读取authorId，并设置
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getUserId();
        dynamicMapper.deleteDynamic(dynamicId,userId);
        return ServerResponse.createBySuccess("删除成功");
    }

    @Override
    public ServerResponse<List<Dynamic>> getDynamicByUserId(Integer userId) {
        List<Dynamic> dynamicList = dynamicMapper.getDynamicByUserId(userId);
        return ServerResponse.createBySuccess("查询成功",dynamicList);
    }

    @Override
    public ServerResponse<List<Dynamic>> getAllDynamic() {
        List<Dynamic> allDynamic = dynamicMapper.getAllDynamic();
        return ServerResponse.createBySuccess("查询成功",allDynamic);
    }
}
