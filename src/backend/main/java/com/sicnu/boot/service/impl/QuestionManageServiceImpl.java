package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.QuestionManageMapper;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.service.QuestionManageService;
import com.sicnu.boot.utils.ServerResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/24 16:25
 */
@Service
public class QuestionManageServiceImpl implements QuestionManageService {

    @Resource
    private QuestionManageMapper questionManageMapper;

    @Override
    public ServerResponse<String> insertQuestion(Question question) {
        String classify = questionManageMapper.getQuestionClassify(question.getClassifyId());
        if (Objects.isNull(classify)){
            return ServerResponse.createByErrorMessage("传入的分类id错误");
        }
        question.setClassifyName(classify);
        questionManageMapper.insertQuestion(question);
        Integer choiceValue = 2;
        if (question.getQuestionType() <= choiceValue){
            for (QuestionChoice questionChoice : question.getQuestionChoiceList()) {
                questionChoice.setQuestionId(question.getQuestionId());
                questionManageMapper.insertQuestionChoice(questionChoice);
            }
        }
        return ServerResponse.createBySuccessMessage("添加成功");
    }
}
