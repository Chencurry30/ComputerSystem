package com.sicnu.boot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.boot.mapper.QuestionMapper;
import com.sicnu.boot.pojo.Question;
import com.sicnu.boot.pojo.QuestionChoice;
import com.sicnu.boot.service.QuestionService;
import com.sicnu.boot.utils.QuestionUtils;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.QuestionClassify;
import com.sicnu.boot.vo.QuestionSelective;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 22:06
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionUtils questionUtils;

    @Override
    public ServerResponse<List<Map<String,Object>>> getFilterBox() {
        List<Map<String,Object>> list = new ArrayList<>();
        //添加题型筛选
        Map<String,Object> typeMap = new HashMap<>(5);
        typeMap.put("id",1);
        typeMap.put("list",questionUtils.getTypeList());
        typeMap.put("name","题型");
        list.add(typeMap);
        //添加难度筛选
        Map<String,Object> difficultMap = new HashMap<>(5);
        difficultMap.put("id",2);
        difficultMap.put("list",questionUtils.getDifficultList());
        difficultMap.put("name","难度");
        list.add(difficultMap);
        //添加题库分类
        List<QuestionClassify> classifyList = questionMapper.getQuestionClassifyList();
        classifyList.add(new QuestionClassify(0,"全部"));
        classifyList.sort(Comparator.comparingInt(QuestionClassify::getClassifyId));
        Map<String,Object> classifyMap = new HashMap<>(10);
        classifyMap.put("id",3);
        classifyMap.put("list",classifyList);
        classifyMap.put("name","题类");
        list.add(classifyMap);
        //添加来源分类
        Map<String,Object> sourceMap = new HashMap<>(5);
        sourceMap.put("id",4);
        sourceMap.put("list",questionUtils.getSourceList());
        sourceMap.put("name","来源");
        list.add(sourceMap);
        //添加年份分类
        Map<String,Object> yearMap = new HashMap<>(5);
        yearMap.put("id",5);
        yearMap.put("list",questionUtils.getYearList());
        yearMap.put("name","年份");
        list.add(yearMap);
        return ServerResponse.createBySuccess("获取成功",list);
    }

    @Override
    public ServerResponse<PageInfo<Question>> getQuestionList(QuestionSelective questionSelective) {
        questionSelective.setTypeName(questionUtils.getTypeById(questionSelective.getTypeId()));
        questionSelective.setDifficultMaxValue(questionUtils.getDifficultMaxById(questionSelective.getDifficultId()));
        questionSelective.setDifficultMinValue(questionUtils.getDifficultMinById(questionSelective.getDifficultId()));
        questionSelective.setSourceName(questionUtils.getSourceById(questionSelective.getSourceId()));
        questionSelective.setYearName(questionUtils.getYearById(questionSelective.getYearId()));
        PageHelper.startPage(questionSelective.getPageNum(),8);
        List<Question> list = questionMapper.getQuestionList(questionSelective);
        for (Question question : list) {
            if (question.getQuestionType() <= 2){
                List<QuestionChoice> choiceList = questionMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
                question.setQuestionChoiceList(choiceList);
            }
        }
        PageInfo<Question> pageInfo = new PageInfo<>(list);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<Question> getQuestionById(Integer questionId) {
        Question question = questionMapper.getQuestionById(questionId);
        //判断是否为选择题
        Integer choiceValue = 2;
        if (question.getQuestionType() <= choiceValue){
            List<QuestionChoice> choiceList = questionMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
            question.setQuestionChoiceList(choiceList);
        }
        return ServerResponse.createBySuccess("获取成功",question);
    }

    @Override
    public ServerResponse<List<Question>> getGeneratingPaper(QuestionSelective questionSelective) {
        List<Question> list = new ArrayList<>();
        if (questionSelective.getSingleChoiceNum() > 0){
            List<Question> generatingPaper = questionMapper.getGeneratingPaper(questionSelective.getClassifyId(),
                    1, questionSelective.getSingleChoiceNum());
            for (Question question : generatingPaper) {
                List<QuestionChoice> choiceList = questionMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
                question.setQuestionChoiceList(choiceList);
            }
            list.addAll(generatingPaper);
        }
        if (questionSelective.getMultipleChoiceNum() > 0){
            List<Question> generatingPaper = questionMapper.getGeneratingPaper(questionSelective.getClassifyId(),
                    2, questionSelective.getMultipleChoiceNum());
            for (Question question : generatingPaper) {
                List<QuestionChoice> choiceList = questionMapper.getQuestionChoiceByQuestionId(question.getQuestionId());
                question.setQuestionChoiceList(choiceList);
            }
            list.addAll(generatingPaper);
        }
        if (questionSelective.getJudgeNum() > 0){
            List<Question> generatingPaper = questionMapper.getGeneratingPaper(questionSelective.getClassifyId(),
                    3, questionSelective.getJudgeNum());
            list.addAll(generatingPaper);
        }
        if (questionSelective.getAnswerNum() > 0){
            List<Question> generatingPaper = questionMapper.getGeneratingPaper(questionSelective.getClassifyId(),
                    4, questionSelective.getAnswerNum());
            list.addAll(generatingPaper);
        }
        return ServerResponse.createBySuccess("获取成功",list);
    }
}
