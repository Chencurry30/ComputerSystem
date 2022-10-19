package com.sicnu.boot.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 *
 * @author :  胡建华
 * Data:    2022/10/19 19:58
 */
public class MyTreeNode {
    private Integer parentId;
    private Integer id;
    /**
     * description: 子节点
     */
    private List<MyTreeNode> commentList;
    /**
     * description: 内容
     */
    private CommentVo content;

    /**
     * description: 创建节点
     */
    public static MyTreeNode buildNode(CommentVo commentVo) {
        MyTreeNode node = new MyTreeNode();
        node.setId(commentVo.getCommentId());
        node.setParentId(commentVo.getParentId());
        node.setContent(commentVo);
        return node;
    }

    /**
     * description: 创建根节点
     */
    public static MyTreeNode buildRoot() {
        MyTreeNode node = new MyTreeNode();
        node.setId(0);
        node.setParentId(-999);
        node.setContent(null);
        ArrayList<MyTreeNode> children=new ArrayList<>();
        node.setChildren(children);
        return node;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MyTreeNode> getChildren() {
        return commentList;
    }

    public void setChildren(List<MyTreeNode> commentList) {
        this.commentList = commentList;
    }

    public CommentVo getContent() {
        return content;
    }

    public void setContent(CommentVo content) {
        this.content = content;
    }
}
