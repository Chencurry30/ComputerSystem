package com.sicnu.boot.controller;

import com.sicnu.boot.service.CommentService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.vo.CommentVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/tree/{resourceId}")
    ServerResponse<List<CommentVo>> getCommentTree(@Min(value = 1,message = "id最小值为1")
                                                   @PathVariable("resourceId") Integer resourceId){
        return commentService.getCommentsById(resourceId);
    }
}
