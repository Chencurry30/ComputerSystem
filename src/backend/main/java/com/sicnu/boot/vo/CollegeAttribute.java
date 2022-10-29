package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/25 21:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeAttribute {
    private Integer attributeId;
    private String attributeName;
    private Integer id;
    private String name;

    public CollegeAttribute(Integer attributeId, String attributeName) {
        this.attributeId = attributeId;
        this.attributeName = attributeName;
        this.name = attributeName;
        this.id = attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
        this.id = attributeId;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
        this.name = attributeName;
    }
}
