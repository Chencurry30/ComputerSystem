package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 21:40
 */
@Mapper
public interface CommentMapper {
    /**
     * description: 通过资源id获取评论列表
     *
     * @param resourceId:
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/10/19 20:38
     */
    List<Comment> getCommentsById(Integer resourceId);

    /**
     * description: 检查资源是否存在
     *
     * @param resourceId:
     * @return int
     * @author 胡建华
     * Date:  2022/11/5 10:25
     */
    int checkResource(Integer resourceId);

    /**
     * description: 插入一条评论
     *
     * @param comment:
     * @return int
     * @author 胡建华
     * Date:  2022/11/5 10:48
     */
    int insertComment(Comment comment);

    /**
     * description: 查询一个资源的父id是否存在
     *
     * @param parentId:
     * @return int
     * @author 胡建华
     * Date:  2022/11/5 14:57
     */
    int checkParent(Integer parentId);

    /**
     * description: 为一个评论点赞
     *
     * @param commentId:
     * @author 胡建华
     * Date:  2022/11/5 15:07
     */
    void updateCommentLikeNumber(Integer commentId);

    /**
     * description: 判断资源类型
     *
     * @param resourceId:
     * @return int
     * @author 胡建华
     * Date:  2022/12/16 10:47
     */
    int checkType(Integer resourceId);
}
