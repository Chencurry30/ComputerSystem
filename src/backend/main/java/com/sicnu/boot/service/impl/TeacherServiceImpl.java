package com.sicnu.boot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.TeacherMapper;

import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.service.TeacherService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/2
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public ServerResponse<Teacher> getTeacherById(Integer id) {
       Teacher teacher=teacherMapper.getTeacherById(id);
        return ServerResponse.createBySuccess("查询成功",teacher);
    }


    @Override
    public ServerResponse<List<Teacher>> getAllTeacher() {
        List<Teacher> allTeacher = teacherMapper.getAllTeacher();
        if (allTeacher.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("查询成功",allTeacher);
    }

    @Override
    public ServerResponse<PageInfo<Teacher>> getTeacherPage(Integer directionId,Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Teacher> list = teacherMapper.getTeacherPage(directionId);
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("查询成功",pageInfo);
    }

    @Override
    public ServerResponse<String> insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
        return ServerResponse.createBySuccessMessage("添加成功");
    }


    @Override
    public ServerResponse<String> updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse<String> deleteTeacherByTeacherId(Integer teacherId) {
        //删除权限对应的角色
        teacherMapper.deleteTeacherByTeacherId(teacherId);
        //删除权限
        return ServerResponse.createBySuccessMessage("删除成功");
    }

}
