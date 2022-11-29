package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * description:  选择题选项表
 *
 * @author :  胡建华
 * Data:    2022/11/08 22:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionChoice {
    @NotNull(message = "选项id不能为空")
    @Min(value = 1,message = "选项id最小为1")
    private Integer choiceId;
    @NotNull(message = "题目id不能为空")
    @Min(value = 1,message = "题目id最小为1")
    private Integer questionId;
    @NotNull(message = "选项名不能为空")
    @Length(min = 1,max = 1,message = "选项名长度只能为1")
    private String choiceName;
    @NotNull(message = "选项题干不能为空")
    @NotBlank(message = "选项题干不能为空")
    private String choiceTitle;
    private String titleImage;
    private boolean checked;
}
