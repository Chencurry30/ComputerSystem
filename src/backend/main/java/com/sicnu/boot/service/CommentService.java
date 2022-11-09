package com.sicnu.boot.service;

import com.sicnu.boot.pojo.Comment;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CommentVo;
import com.sicnu.boot.vo.CommentVos;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 21:38
 */
public interface CommentService {
    /**
     * description: 通过资源id获取评论列表
     *
     * @param resourceId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/19 20:38
     */
    ServerResponse<List<CommentVos>> getCommentsById(Integer resourceId);

    /**
     * description: 插入一条评论
     *
     * @param comment:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/5 10:11
     */
    ServerResponse<String> insertComment(Comment comment);

    /**
     * description: 为一个评论点赞
     *
     * @param commentId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/5 15:06
     */
    ServerResponse<String> updateCommentLikeNumber(Integer commentId);
}
