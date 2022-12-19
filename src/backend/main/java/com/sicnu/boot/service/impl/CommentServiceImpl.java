package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.CommentMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.mapper.VideoMapper;
import com.sicnu.boot.pojo.Comment;
import com.sicnu.boot.pojo.User;
import com.sicnu.boot.service.CommentService;
import com.sicnu.boot.utils.ResponseCode;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.TreeUtils;
import com.sicnu.boot.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 21:38
 */
@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private TreeUtils treeUtils;

    @Override
    public ServerResponse<List<CommentVos>> getCommentsById(Integer resourceId) {
        //查询文章所有的评论
        List<Comment> comments = commentMapper.getCommentsById(resourceId);
        if (comments.isEmpty()){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.HAS_NO_DATA.getCode(),
                    "数据为空");
        }
        //补充评论用户信息
        List<CommentVo> commentVos = comments.stream().map(comment -> {
            CommentVo commentVo = new CommentVo(comment);
            //查询作者信息
            CommentUserVo author = userMapper.getCommentUserById(comment.getAuthorId());
            commentVo.setAuthor(author);
            //toUser信息 level>1 说明有回复对象
            if (comment.getLevel() > 1) {
                CommentUserVo toUser = userMapper.getCommentUserById(comment.getToUid());
                commentVo.setToUser(toUser);
            }
            return commentVo;
        }).collect(Collectors.toList());
        //构造生成树
        MyTreeNode myTree = treeUtils.buildTree(commentVos);
        //返回根节点的子节点（即level为1的评论 ）
        List<MyTreeNode> children = myTree.getChildren();
        List<CommentVo> level1CommentVo = new ArrayList<>();
        for (MyTreeNode child : children) {
            level1CommentVo.add(child.getContent());
        }
        //构造前端想要的数据
        List<CommentVos> commentVosList = new ArrayList<>();
        for (CommentVo commentVo : level1CommentVo) {
            CommentVos commentVos1 = new CommentVos();
            commentVos1.setId(commentVo.getCommentId());
            commentVos1.setComment(commentVo);
            commentVos1.setChildren(commentVo.getChildren());
            commentVos1.getComment().setChildren(null);
            commentVosList.add(commentVos1);
        }
        return ServerResponse.createBySuccess("返回成功",commentVosList);
    }

    @Override
    public ServerResponse<String> insertComment(Comment comment) {
        //检查是否拥有该资源
        int checkResource = commentMapper.checkResource(comment.getResourceId());
        if (checkResource < 1){
            log.error("插入评论时，不存在该评论评论的资源，资源id：{}",comment.getResourceId());
            return ServerResponse.createByErrorMessage("该资源不存在");
        }
        //检查parentId是否正确
        if (comment.getParentId() != 0){
            int checkParent = commentMapper.checkParent(comment.getParentId());
            if (checkParent < 1){
                log.error("插入评论时，不存在该评论的父id，父id：{}",comment.getParentId());
                return ServerResponse.createByErrorMessage("父id不存在");
            }
        }
        //检查toUid是否正确
        if (comment.getToUid() != 0){
            User user = userMapper.getUserById(comment.getToUid());
            if (user == null){
                log.error("插入评论时，评论对象的id不存在，评论对象id：{}",comment.getToUid());
                return ServerResponse.createByErrorMessage("评论对象id不存在");
            }
        }
        //从redis中读取authorId，并设置
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        comment.setAuthorId(loginUser.getUser().getUserId());
        //设置评论时间
        comment.setCreateDate(LocalDateTime.now());
        int insertComment = commentMapper.insertComment(comment);
        if (insertComment > 0){
            //为评论数加1
            int type = commentMapper.checkType(comment.getResourceId());
            if (type == 0){
                //为视频评论数加1
                videoMapper.updateAddCommentNum(comment.getResourceId());
            }
        }
        return ServerResponse.createBySuccessMessage("插入成功");
    }

    @Override
    public ServerResponse<String> updateCommentLikeNumber(Integer commentId) {
        commentMapper.updateCommentLikeNumber(commentId);
        return ServerResponse.createBySuccessMessage("点赞成功");
    }
}
