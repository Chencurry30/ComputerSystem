package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.TeacherQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherQuestionMapper {
    /**
     * 通过老师id查询对老师的提问
     * @param teacherId：老师id
     * @return TeacherQuestion
     */
     List<TeacherQuestion> getTeacherQuestionById(Integer teacherId);

    /**
     * 通过老师ID插入提问
     * @param teacher：老师
     */
    void insertTeacherQuestion(TeacherQuestion teacher);

    /**
     * 通过老师id查询老师未进行回复的提问
     * @param teacherId：老师id
     * @return TeacherQuestion
     */
    List<TeacherQuestion> getTeacherAnswerById(Integer teacherId);

    /**
     * 将已回复消息设置为不可见
     * @param userId：老师
     */
    void updateTeacherAnswer(Integer userId);

}
