package com.sicnu.boot.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/11/09 21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVos {
    private Integer id;
    private CommentVo comment;
    private List<CommentVo> children;
}
