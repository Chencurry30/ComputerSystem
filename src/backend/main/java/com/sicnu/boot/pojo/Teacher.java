package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author 汪杨
 * @version 1.0
 * description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @NotNull(message = "老师ID不能为空")
    private Integer teacherId;
    @NotNull(message = "老师姓名不能为空")
    @NotBlank(message = "老师姓名不能为空字符串")
    private String name;
    @NotNull(message = "老师的学业背景不能为空")
    private String background;
    private Integer directionId;
    @NotNull(message = "老师的教授方向不能为空")
    private String directionName;
    private String image;
    private Integer teachTime;
    private String information;
    private Integer attentPeople;
    private String qualification;
    private Integer userId;
    private String nickName;
}
