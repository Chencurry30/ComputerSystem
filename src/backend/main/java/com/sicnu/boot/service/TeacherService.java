package com.sicnu.boot.service;


import com.sicnu.boot.pojo.Teacher;
import com.sicnu.boot.utils.ServerResponse;

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
}
