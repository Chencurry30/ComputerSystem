package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * description:  回复
 *
 * @author :  胡建华
 * Data:    2022/10/15 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
    private Integer replyId;
    private String content;
    private LocalDateTime time;
    private Integer userId;
    private Integer commentId;
    private Integer likeNumber;
}
