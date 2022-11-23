package com.sicnu.boot.service;

import com.sicnu.boot.pojo.TeacherQuestion;
import com.sicnu.boot.utils.ServerResponse;
import java.util.List;

public interface TeacherQuestionService {
    ServerResponse<List<TeacherQuestion>> getTeacherQuestionById(Integer id);
}
