package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/25 18:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoType {
    private Integer typeId;
    private Integer id;
    private String name;
    private String typeName;

    public VideoType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.id = typeId;
        this.name = typeName;
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
