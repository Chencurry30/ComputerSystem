package com.sicnu.boot.mapper;

import com.sicnu.boot.pojo.Comment;
import com.sicnu.boot.utils.ServerResponse;
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
}
