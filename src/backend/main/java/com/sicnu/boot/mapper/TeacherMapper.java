package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

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
     * @return Teacher
     */
     Teacher getTeacherById(Integer teacherId);

     /**
      * 查询所有老师基本信息
      * @return Teacher
      */
     List<Teacher> getAllTeacher();

     List<Teacher> getTeacherPage(Integer directionId);

     /**
      * 新增老师信息
      * @param teacher：老师
      */
     void insertTeacher(Teacher teacher);

     /**
      * 修改老师信息
      * @param teacher：老师
      */
     void updateTeacher(Teacher teacher);

     /**
      * 删除老师信息
      * @param teacherId:老师Id
      */
     void deleteTeacherByTeacherId(Integer teacherId);

}
