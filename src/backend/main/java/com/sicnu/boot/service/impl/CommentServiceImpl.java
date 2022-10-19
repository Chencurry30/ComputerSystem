package com.sicnu.boot.service.impl;

import com.sicnu.boot.mapper.CommentMapper;
import com.sicnu.boot.mapper.UserMapper;
import com.sicnu.boot.pojo.Comment;
import com.sicnu.boot.service.CommentService;
import com.sicnu.boot.utils.ServerResponse;
import com.sicnu.boot.utils.TreeUtils;
import com.sicnu.boot.vo.CommentUserVo;
import com.sicnu.boot.vo.CommentVo;
import com.sicnu.boot.vo.MyTreeNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 21:38
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;

    @Resource
    private UserMapper userMapper;

    @Resource
    private TreeUtils treeUtils;

    @Override
    public ServerResponse<List<CommentVo>> getCommentsById(Integer resourceId) {
        //查询文章所有的评论
        List<Comment> comments = commentMapper.getCommentsById(resourceId);
        //补充评论用户信息
        List<CommentVo> commentVos = new ArrayList<>();
        for (Comment comment : comments) {
            CommentVo commentVo = new CommentVo(comment);
            //查询作者信息
            CommentUserVo author = userMapper.getCommentUserById(comment.getAuthorId());
            commentVo.setAuthor(author);
            //toUser信息 level>1 说明有回复对象
            if (comment.getLevel() > 1){
                CommentUserVo toUser = userMapper.getCommentUserById(comment.getToUid());
                commentVo.setToUser(toUser);
            }
            commentVos.add(commentVo);
        }
        //构造生成树
        MyTreeNode myTree = treeUtils.buildTree(commentVos);
        //返回根节点的子节点（即level为1的评论 ）
        List<MyTreeNode> children = myTree.getChildren();
        List<CommentVo> level1CommentVo = new ArrayList<>();
        for (MyTreeNode child : children) {
            level1CommentVo.add(child.getContent());
        }
        return ServerResponse.createBySuccess("返回成功",level1CommentVo);
    }
}
