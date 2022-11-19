package com.sicnu.boot.controller;

import com.sicnu.boot.pojo.Comment;
import com.sicnu.boot.service.CommentService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CommentVos;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 23:12
 */
@RestController
@RequestMapping("/comments")
@Validated
public class CommentController {
    @Resource
    private CommentService commentService;

    /**
     * description: 获取一个资源的评论树
     *
     * @param resourceId:
     * @return ServerResponse<List<CommentVo>>
     * @author 胡建华
     * Date:  2022/11/5 10:47
     */
    @GetMapping("/tree/{resourceId}")
    ServerResponse<List<CommentVos>> getCommentTree(@Min(value = 1,message = "id最小值为1")
                                                   @PathVariable("resourceId") Integer resourceId){
        return commentService.getCommentsById(resourceId);
    }

    /**
     * description: 插入一个评论
     *
     * @param comment:
     * @return ServerResponse<String>
     * @author 胡建华
     * Date:  2022/11/5 10:47
     */
    @PostMapping("")
    ServerResponse<String> insertComment(@Validated @RequestBody Comment comment){
        return commentService.insertComment(comment);
    }

    /**
     * description: 给一个评论点赞
     *
     * @return ServerResponse
     * @author 胡建华
     * Date:  2022/11/5 15:05
     */
    @PutMapping("/like/{commentId}")
    ServerResponse<String> updateCommentLikeNumber(@Min(value = 1,message = "id最小值为1")
                                                   @PathVariable Integer commentId){
        return commentService.updateCommentLikeNumber(commentId);
    }
}
