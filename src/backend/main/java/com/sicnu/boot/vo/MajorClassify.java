package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/15 21:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MajorClassify {
    private Integer classifyId;
    private String classifyName;
    private Integer id;
    private String name;

    public MajorClassify(Integer classifyId, String classifyName) {
        this.classifyId = classifyId;
        this.classifyName = classifyName;
        this.name = classifyName;
        this.id = classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
        this.id = classifyId;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
        this.name = classifyName;
    }
}
