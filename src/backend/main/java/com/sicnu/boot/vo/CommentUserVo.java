package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 19:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentUserVo {
    private Integer userId;
    private String nickname;
    private String image;
}
