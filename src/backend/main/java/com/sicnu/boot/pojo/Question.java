package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sicnu.boot.group.Insert;
import com.sicnu.boot.group.Update;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    private Integer id;
    @NotNull(message = "题目id不能为空",groups = {Update.class})
    @Min(value = 1,message = "题目id最小为1")
    private Integer questionId;
    /**
     * description: 题目题干
     */
    @NotNull(message = "题干不能为空")
    @NotBlank(message = "题干不能为空")
    private String questionTitle;

    private String titleImage;

    private String enclosureImage;
    /**
     * description: 题目答案
     */
    @NotBlank(message = "题目答案不能为空")
    @NotNull(message = "题目答案不能为空")
    private String answer;

    private String answerImage;
    /**
     * description: 题目类型，1为单选，2为多选，3为判断，4为简答
     */
    @NotNull(message = "题目类型不能为空")
    @Min(value = 1,message = "题目类型最小值为1")
    private Integer questionType;
    /**
     * description: 题目解答
     */
    @NotNull(message = "题目解答不能为空")
    @NotBlank(message = "题目解答不能为空")
    private String solution;

    private String solutionImage;
    /**
     * description: 题目考点
     */
    @NotNull(message = "题目考点不能为空",groups = {Insert.class})
    @NotBlank(message = "题目考点不能为空",groups = {Insert.class})
    private String sites;
    /**
     * description:
     */
    @NotNull(message = "题目分类不能为空",groups = {Insert.class})
    @Min(value = 1,message = "题目分类最小值为1")
    private Integer classifyId;
    /**
     * description: 题目分类名字
     */
    private String classifyName;
    /**
     * description: 题目难度
     */
    @NotNull(message = "题目难度不能为空",groups = {Insert.class})
    @DecimalMin(value = "0.1",message = "题目难度最小值为0.1")
    private BigDecimal difficult;
    /**
     * description: 题目来源
     */
    @NotNull(message = "题目来源不能为空",groups = {Insert.class})
    @NotBlank(message = "题目来源不能为空",groups = {Insert.class})
    private String source;
    /**
     * description: 题目年份
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy")
    @NotNull(message = "题目年份不能为空",groups = {Insert.class})
    private Date year;

    private Boolean isCollected;
    /**
     * description: 选择题选项列表
     */
    @Valid
    private List<QuestionChoice> questionChoiceList = new ArrayList<>();
}
