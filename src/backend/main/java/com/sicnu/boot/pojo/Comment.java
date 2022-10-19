package com.sicnu.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String content;
    private LocalDateTime createDate;
    private Integer resourceId;
    private Integer authorId;
    private Integer parentId;
    private Integer toUid;
    private Integer level;
    private Integer likeNumber;
}
