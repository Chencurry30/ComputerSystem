package com.sicnu.boot.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.TeacherMapper;

import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.service.TeacherService;
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
        return ServerResponse.createBySuccess("查询成功",allTeacher);
    }

    @Override
    public ServerResponse<PageInfo<Teacher>> getTeacherPage(Integer pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Teacher> list = teacherMapper.getAllTeacher();
        PageInfo<Teacher> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("查询成功",pageInfo);
    }

    @Override
    public ServerResponse<String> insertTeacher(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
        return ServerResponse.createBySuccess("添加成功");
    }


    @Override
    public ServerResponse<String> updateTeacher(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
        return ServerResponse.createBySuccess("更新成功");
    }

    @Override
    public ServerResponse<String> deleteTeacherByTeacherId(Integer teacherId) {
        //删除权限对应的角色
        teacherMapper.deleteRoleTeacherByTeacherId(teacherId);
        //删除权限
        return ServerResponse.createBySuccess("删除成功");
    }
}
