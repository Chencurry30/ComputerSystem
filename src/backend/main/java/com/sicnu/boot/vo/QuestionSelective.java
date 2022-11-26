package com.sicnu.boot.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 21:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionSelective {
    private String questionName;
    private Integer typeId;
    private Integer typeName;
    private Integer difficultId;
    private BigDecimal difficultMinValue;
    private BigDecimal difficultMaxValue;
    @NotNull(message = "题目分类不能为空")
    @Min(value = 1,message = "题目分类id最小值为1")
    private Integer classifyId;
    private Integer sourceId;
    private String sourceName;
    private Integer yearId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date yearName;
    private Integer pageNum;

    /**
     * description: 选择题题量
     */
    @NotNull(message = "选择题题量不能为空")
    @Range(min = 0,max = 10,message = "选择题题量必须为0 - 10")
    private Integer singleChoiceNum;
    /**
     * description: 多选题题量
     */
    @NotNull(message = "多选题题量不能为空")
    @Range(min = 0,max = 10,message = "多选题题量必须为0 - 10")
    private Integer multipleChoiceNum;
    /**
     * description: 填空题题量
     */
    @NotNull(message = "填空题题量不能为空")
    @Range(min = 0,max = 10,message = "填空题题量必须为0 - 10")
    private Integer completionNum;
    /**
     * description: 解答题题量
     */
    @NotNull(message = "解答题题量不能为空")
    @Range(min = 0,max = 10,message = "解答题题量必须为0 - 10")
    private Integer answerNum;

    public QuestionSelective(Integer typeId, Integer difficultId, Integer classifyId, Integer sourceId, Integer yearId,Integer pageNum) {
        this.typeId = typeId;
        this.difficultId = difficultId;
        this.classifyId = classifyId;
        this.sourceId = sourceId;
        this.yearId = yearId;
        this.pageNum = pageNum;
    }

    public QuestionSelective(String questionName, Integer classifyId, Integer sourceId, Integer pageNum) {
        this.questionName = questionName;
        this.classifyId = classifyId;
        this.sourceId = sourceId;
        this.pageNum = pageNum;
    }
}
