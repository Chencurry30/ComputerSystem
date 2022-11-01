package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author 蔡名展
 * @version 1.0
 * description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
    private Integer collegeId;
    private String name;
    private String address;
    private Integer typeId;
    private String type;
    private Integer regionId;
    private String region;
    private String phone;
    private Integer rank;
    private Integer attributeId;
    private String attribute;
    private String disDevelop;
}
