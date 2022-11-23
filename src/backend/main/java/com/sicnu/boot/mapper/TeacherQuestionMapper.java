package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.TeacherQuestion;

import java.util.List;

public interface TeacherQuestionMapper {
    /**
     * 通过id查询对老师的评论
     * @param teacherId：老师id
     * @return TeacherQuestion
     */
     List<TeacherQuestion> getTeacherQuestionById(Integer teacherId);
}
