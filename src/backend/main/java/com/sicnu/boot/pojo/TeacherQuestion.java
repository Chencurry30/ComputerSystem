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
public class TeacherQuestion {
    private Integer teacherId;
    private String question;
    @NotNull(message = "提问不能为空")
    @NotBlank(message = "提问不能为空字符串")
    private Integer userId;
}
