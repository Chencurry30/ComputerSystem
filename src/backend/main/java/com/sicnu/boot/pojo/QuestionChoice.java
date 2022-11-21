package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer choiceId;
    private String choiceName;
    private String choiceTitle;
    private boolean checked;
}
