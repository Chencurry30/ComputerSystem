package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 汪杨
 * @version 1.0
 * description :
 * @date 2022/11/2 14:39
 */
@Mapper
public interface TeacherMapper {
     /**
     * 通过id查询老师基本信息
     * @param teacherId：老师id
     * @return College
     */
     Teacher getTeacherById(Integer teacherId);
}
