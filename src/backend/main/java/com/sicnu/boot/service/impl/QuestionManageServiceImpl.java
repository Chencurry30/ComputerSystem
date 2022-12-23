package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.aop.SysLogAnnotation;
import com.sicnu.boot.mapper.QuestionManageMapper;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.service.QuestionManageService;
import com.sicnu.boot.utils.QuestionUtils;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionSelective;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    @Resource
    private QuestionUtils questionUtils;

    @Override
    @SysLogAnnotation(operModel = "题库管理",operType = "新增",operDesc = "新增题目")
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

    @Override
    @SysLogAnnotation(operModel = "题库管理",operType = "更新",operDesc = "更新题目")
    public ServerResponse<String> updateQuestion(Question question) {
        questionManageMapper.updateQuestion(question);
        Integer choiceValue = 2;
        if (question.getQuestionType() <= choiceValue){
            for (QuestionChoice questionChoice : question.getQuestionChoiceList()) {
                questionManageMapper.updateQuestionChoice(questionChoice);
            }
        }
        return ServerResponse.createBySuccess("修改成功");
    }

    @Override
    @SysLogAnnotation(operModel = "题库管理",operType = "删除",operDesc = "删除指定题目")
    public ServerResponse<String> deleteQuestionById(Integer questionId) {
        Integer count = questionManageMapper.checkQuestionType(questionId);
        Integer choiceValue = 2;
        if (count <= choiceValue){
            questionManageMapper.deleteQuestionChoice(questionId);
        }
        questionManageMapper.deleteQuestionById(questionId);
        return ServerResponse.createBySuccessMessage("删除成功");
    }

    @Override
    public ServerResponse<Question> getQuestionInfoById(Integer questionId) {
        Question question = questionManageMapper.getQuestionInfoById(questionId);
        if (Objects.isNull(question)){
            return ServerResponse.createByErrorMessage("没有该题目");
        }
        Integer choiceValue = 2;
        if (question.getQuestionType() <= choiceValue){
            List<QuestionChoice> choiceList = questionManageMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
            question.setQuestionChoiceList(choiceList);
        }
        return ServerResponse.createBySuccess("获取成功",question);
    }

    @Override
    public ServerResponse<PageInfo<Question>> getQuestionList(QuestionSelective questionSelective) {
        questionSelective.setSourceName(questionUtils.getSourceById(questionSelective.getSourceId()));
        PageHelper.startPage(questionSelective.getPageNum(),8);
        List<Question> list = questionManageMapper.getQuestionList(questionSelective);
        for (Question question : list) {
            if (question.getQuestionType() <= 2){
                List<QuestionChoice> choiceList = questionManageMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
                question.setQuestionChoiceList(choiceList);
            }
        }
        PageInfo<Question> pageInfo = new PageInfo<>(list);
        if (list.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
}
