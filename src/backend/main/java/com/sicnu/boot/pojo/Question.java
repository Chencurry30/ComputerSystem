package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description:  题目
 *
 * @author :  胡建华
 * Data:    2022/11/08 22:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Question {
    private Integer questionId;
    /**
     * description: 题目类型，1为单选，2为多选，3为判断，4为简答
     */
    private Integer questionType;
    /**
     * description: 题目题干
     */
    private String questionTitle;
    /**
     * description:
     */
    private Integer classifyId;
    /**
     * description: 题目分类名字
     */
    private String classifyName;
    /**
     * description: 题目附件
     */
    private String documentLocation;
    /**
     * description: 题目答案
     */
    private String answer;
    /**
     * description: 题目解析
     */
    private String analysis;
    /**
     * description: 选择题选项列表
     */
    private List<QuestionChoice> questionChoiceList;
}
