package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/10/25 22:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CollegeSelective {
    private String collegeName;
    private Integer regionId;
    private Integer typeId;
    private Integer attributeId;
    private Integer pageNum;
}
