package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author 蔡名展
 * @version 1.0
 * @date 2022/11/26 13:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dynamic {
    private Integer userId;
    private Integer dynamicId;
    @NotNull(message = "动态内容不能为空")
    @NotBlank(message = "动态内容不能为空字符串")
    private String content;
    private String picture;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
}
