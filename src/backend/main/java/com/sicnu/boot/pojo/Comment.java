package com.sicnu.boot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 20:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer commentId;
    @NotNull(message = "评论内容不能为空")
    @NotBlank(message = "评论内容不能为空字符串")
    private String content;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    @NotNull(message = "资源id不能为空")
    @Range(min = 1,message = "资源id最小为1")
    private Integer resourceId;
    private Integer authorId;
    @NotNull(message = "父id不能为空")
    @Min(value = 0,message = "父id最小为0")
    private Integer parentId;
    @NotNull(message = "评论对象id不能为空")
    @Min(value = 0,message = "评论对象id最小为0")
    private Integer toUid;
    @NotNull(message = "level不能为空")
    @Range(min = 1,max = 5,message = "level必须在1-5的范围内")
    private Integer level;
    private Integer likeNumber;
}
