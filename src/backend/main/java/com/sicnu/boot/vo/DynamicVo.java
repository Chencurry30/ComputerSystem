package com.sicnu.boot.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicnu.boot.pojo.Dynamic;
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
 * @date 2022/11/29 14:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DynamicVo {
    private Integer userId;
    private Integer dynamicId;
    private CommentUserVo author;
    @NotNull(message = "动态内容不能为空")
    @NotBlank(message = "动态内容不能为空字符串")
    private String content;
    private String picture;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    public DynamicVo(Dynamic dynamic) {
        this.userId = dynamic.getUserId();
        this.dynamicId = dynamic.getDynamicId();
        this.content = dynamic.getContent();
        this.picture = dynamic.getPicture();
        this.createDate = dynamic.getCreateDate();
    }
}
