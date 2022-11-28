package com.sicnu.boot.service;

import com.sicnu.boot.pojo.TeacherQuestion;
import com.sicnu.boot.utils.ServerResponse;
import java.util.List;

public interface TeacherQuestionService {
    /**
     * 打印提问
     * @param id：老师id
     * @return null
     */
    ServerResponse<List<TeacherQuestion>> getTeacherQuestionById(Integer id);

    /**
     * 插入提问
     * @param teacher：老师
     * @return null
     */
    ServerResponse<String> insertTeacherQuestion(TeacherQuestion teacher);

    /**
     * 老师页面打印问题
     * @param id：老师id
     * @return null
     */
    ServerResponse<List<TeacherQuestion>> getTeacherAnswerById(Integer id);

    /**
     * 插入回复
     * @param userId：学生id
     * @return null
     */
    ServerResponse<String> updateTeacherAnswer(Integer userId);
}
