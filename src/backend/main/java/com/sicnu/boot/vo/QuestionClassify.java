package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/15 22:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionClassify {
    private Integer classifyId;
    private Integer id;
    private String classifyName;
    private String name;

    public QuestionClassify(Integer classifyId, String classifyName) {
        this.name = classifyName;
        this.id = classifyId;
        this.classifyId = classifyId;
        this.classifyName = classifyName;
    }

    public void setClassifyId(Integer classifyId) {
        this.id = classifyId;
        this.classifyId = classifyId;
    }

    public void setClassifyName(String classifyName) {
        this.name = classifyName;
        this.classifyName = classifyName;
    }
}
