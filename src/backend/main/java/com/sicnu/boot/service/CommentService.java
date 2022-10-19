package com.sicnu.boot.service;

import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CommentVo;

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
    ServerResponse<List<CommentVo>> getCommentsById(Integer resourceId);
}
