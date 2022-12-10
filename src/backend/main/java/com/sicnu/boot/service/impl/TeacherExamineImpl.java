package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.TeacherExamineMapper;
import com.sicnu.boot.pojo.TeacherExamine;
import com.sicnu.boot.service.TeacherExamineService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class TeacherExamineImpl implements TeacherExamineService {
    @Resource
    private TeacherExamineMapper examineMapper;
    @Override
    public ServerResponse<List<TeacherExamine>> getAllExamine() {
        List<TeacherExamine> allExamine = examineMapper.getAllExamine();
        return ServerResponse.createBySuccess("查询成功",allExamine);
    }

    @Override
    public ServerResponse<String> insertExamine(TeacherExamine examine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getUserId();
        examine.setUserId(userId);
        examineMapper.insertExamine(examine);
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<String> updateAgrExamine(Integer userId) {
        examineMapper.updateAgrExamine(userId);
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<String> updateDisAgrExamine(Integer userId){
        examineMapper.updateDisAgrExamine(userId);
        return ServerResponse.createBySuccessMessage("更新成功");
    }
}