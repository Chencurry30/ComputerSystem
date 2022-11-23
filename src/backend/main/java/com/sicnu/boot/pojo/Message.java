package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author 汪杨
 * @version 1.0
 * @date 2022/10/20 10:01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer messageId;
    private Integer userId;
    private String nickname;
    private String content;
    @NotNull(message = "评论内容不能为空")
    @NotBlank(message = "评论内容不能为空字符串")
    private LocalDateTime messageTime;
    private Integer teacherId;

}
