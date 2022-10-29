package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/25 20:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeType {
    private Integer typeId;
    private String typeName;
    private Integer id;
    private String name;

    public CollegeType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.name = typeName;
        this.id = typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
        this.id = typeId;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
        this.name = typeName;
    }
}
