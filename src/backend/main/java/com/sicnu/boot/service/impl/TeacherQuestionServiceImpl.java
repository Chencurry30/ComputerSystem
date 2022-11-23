package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.TeacherQuestionMapper;
import com.sicnu.boot.pojo.TeacherQuestion;
import com.sicnu.boot.service.TeacherQuestionService;
import com.sicnu.boot.utils.ServerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * description:根据老师id查看提问
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/11/23 12:49
 */
@Service
@Slf4j
public class TeacherQuestionServiceImpl implements TeacherQuestionService {
    @Resource
    private TeacherQuestionMapper teacherQuestionMapper;

    public ServerResponse<List<TeacherQuestion>> getTeacherQuestionById(Integer id) {
        List<TeacherQuestion> questions=teacherQuestionMapper.getTeacherQuestionById(id);
        return ServerResponse.createBySuccess("查询成功",questions);
    }
}
