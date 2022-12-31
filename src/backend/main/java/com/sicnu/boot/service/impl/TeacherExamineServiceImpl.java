package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.TeacherExamineMapper;
import com.sicnu.boot.pojo.TeacherExamine;
import com.sicnu.boot.service.TeacherExamineService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class TeacherExamineServiceImpl implements TeacherExamineService {
    @Resource
    private TeacherExamineMapper examineMapper;
    @Override
    public ServerResponse<List<TeacherExamine>> getAllExamine() {
        List<TeacherExamine> allExamine = examineMapper.getAllExamine();
        if (allExamine.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("查询成功",allExamine);
    }

    @Override
    public ServerResponse<String> insertExamine(TeacherExamine examine) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Integer userId = loginUser.getUser().getUserId();
        examine.setUserId(userId);
        examine.setApplyDate(LocalDateTime.now());
        examineMapper.deleteExamine(userId);
        examineMapper.insertExamine(examine);
        return ServerResponse.createBySuccessMessage("添加成功");
    }

    @Override
    public ServerResponse<String> updateAgrExamine(Integer examineId) {
        examineMapper.updateAgrExamine(examineId);
        TeacherExamine teacherExamine = examineMapper.getExamine(examineId);
        teacherExamine.setPassDate(LocalDateTime.now());
        examineMapper.passExamine(teacherExamine);
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<String> updateDisAgrExamine(Integer examineId,String reviewComment){
        examineMapper.updateDisAgrExamine(examineId,reviewComment);
        return ServerResponse.createBySuccessMessage("更新成功");
    }
}
