package com.sicnu.boot.service;



import com.github.pagehelper.PageInfo;
import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.utils.ServerResponse;

import java.util.List;


/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/2
 */
public interface TeacherService {
    /**
     * 获取老师信息
     *
     * @param id：老师id
     * @return ServerResponse<Teacher>
     */
    ServerResponse<Teacher> getTeacherById(Integer id);

    /**
     * 查询所有老师
     *
     * @return null
     */
    ServerResponse<List<Teacher>> getAllTeacher();

    /**
     * 页码数
     * @param pageNum：页码数
     * @return null
     */
    ServerResponse<PageInfo<Teacher>> getTeacherPage(Integer directionId,Integer pageNum);

    /**
     * 新增老师信息
     * @param teacher：老师
     * @return null
     */
    ServerResponse<String> insertTeacher(Teacher teacher);


    /**
     * 修改老师信息
     * @param teacher：老师
     * @return null
     */
    ServerResponse<String> updateTeacher(Teacher teacher);

    /**
     * 删除老师信息
     * @param teacherId:老师Id
     * @return null
     */
    ServerResponse<String> deleteTeacherByTeacherId(Integer teacherId);


}
