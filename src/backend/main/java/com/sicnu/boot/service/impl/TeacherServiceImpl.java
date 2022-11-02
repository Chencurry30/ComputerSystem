package com.sicnu.boot.service.impl;


import com.sicnu.boot.mapper.TeacherMapper;
import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.service.TeacherService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
