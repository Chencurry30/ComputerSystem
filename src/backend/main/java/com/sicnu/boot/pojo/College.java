package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author 蔡名展
 * @version 1.0
 * description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class College {
    private Integer id;
    private Integer collegeId;
    private String name;
    private String address;
    private Integer typeId;
    private String type;
    private Integer regionId;
    private String region;
    private String phone;
    private Integer attributeId;
    private String attribute;
    private Integer subjectionId;
    private String subjection;
    private String web;
    private String mail;
    private String introduction;
}
