package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherExamine {
    private Integer examineId;
    @NotNull(message = "姓名不能为空")
    private String name;
    @NotNull(message = "教师背景不能为空")
    private String background;
    private Integer directionId;
    @NotNull(message = "专业方向不能为空")
    private String directionName;
    private String image;
    private Integer teachTime;
    private String information;
    private Integer attentPeople;
    private String qualification;
    private Integer userId;
    private String applyReason;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime applyDate;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime passDate;
    private Integer examineStatus;
    private Integer applyId;
    private String reviewComment;
}
