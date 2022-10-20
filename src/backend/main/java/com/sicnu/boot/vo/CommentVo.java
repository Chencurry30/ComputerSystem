package com.sicnu.boot.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sicnu.boot.pojo.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * description:  评论
 *
 * @author :  胡建华
 * Data:    2022/10/15 15:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private Integer commentId;
    private String content;
    @JsonFormat(timezone = "GMT+8",pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;
    private Integer resourceId;
    private CommentUserVo author;
    private Integer parentId;
    private CommentUserVo toUser;
    private Integer level;
    private Integer likeNumber;
    private List<CommentVo> children;

    public CommentVo(Comment comment){
        this.commentId = comment.getCommentId();
        this.content = comment.getContent();
        this.createDate = comment.getCreateDate();
        this.resourceId = comment.getResourceId();
        this.parentId = comment.getParentId();
        this.level = comment.getLevel();
        this.likeNumber = comment.getLikeNumber();
    }
}
