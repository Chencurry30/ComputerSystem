package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description:  评论
 *
 * @author :  胡建华
 * Data:    2022/10/15 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer commentId;
    private String content;
    private LocalDateTime time;
    private Integer userId;
    private Integer resourceId;
    private Integer likeNumber;
}
