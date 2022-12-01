package com.sicnu.boot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.DynamicMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.Dynamic;
import com.sicnu.boot.service.DynamicService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CommentUserVo;
import com.sicnu.boot.vo.DynamicVo;
import com.sicnu.boot.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Resource
    private UserMapper userMapper;

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
    public ServerResponse<PageInfo<DynamicVo>> getDynamicByUserId(Integer userId,Integer pageNum) {
        //获取分页信息
        PageHelper.startPage(pageNum, 5);
        List<DynamicVo> dynamicList = dynamicMapper.getDynamicByUserId(userId);
        //补充动态作者信息
        for(DynamicVo dynamicVo : dynamicList){
            //查询作者信息
            CommentUserVo author = userMapper.getCommentUserById(dynamicVo.getUserId());
            dynamicVo.setAuthor(author);
        }
        PageInfo<DynamicVo> pageInfo = new PageInfo<>(dynamicList);
        return ServerResponse.createBySuccess("查询成功",pageInfo);
    }

    @Override
    public ServerResponse<PageInfo<DynamicVo>> getAllDynamic(Integer pageNum) {
        //获取分页信息
        PageHelper.startPage(pageNum, 5);
        List<DynamicVo> allDynamic = dynamicMapper.getAllDynamic();
        for(DynamicVo dynamicVo : allDynamic){
            CommentUserVo author = userMapper.getCommentUserById(dynamicVo.getUserId());
            dynamicVo.setAuthor(author);
        }
        PageInfo<DynamicVo> pageInfo = new PageInfo<>(allDynamic);
        return ServerResponse.createBySuccess("查询成功",pageInfo);
    }
}
