package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.TeacherQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherQuestionMapper {
    /**
     * 通过id查询对老师的评论
     * @param teacherId：老师id
     * @return TeacherQuestion
     */
     List<TeacherQuestion> getTeacherQuestionById(Integer teacherId);
}
