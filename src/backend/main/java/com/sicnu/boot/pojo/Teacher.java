package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 汪杨
 * @version 1.0
 * description:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    private Integer teacherId;
    private String name;
    private String background;
    private Integer directionId;
    private String directionName;
    private String image;
    private Integer teacherTime;
    private String information;
    private Integer attentPeople;
    private String qualification;
    private Integer userId;
}
