package com.sicnu.boot.utils;

import com.sicnu.boot.pojo.Menu;
import com.sicnu.boot.vo.CommentVo;
import com.sicnu.boot.vo.MyTreeNode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * description:  实现多级评论，将资源的全部评论封装成为一棵树
 *
 * @author :  胡建华
 * Data:    2022/10/19 20:21
 */
@Component
public class TreeUtils {
    /**
     * description: 生成树
     *
     * @param commentVoList:
     * @return MyTreeNode
     * @author 胡建华
     * Date:  2022/10/19 20:24
     */
    public MyTreeNode buildTree(List<CommentVo> commentVoList){
        //创建根节点 id为0
        MyTreeNode root = MyTreeNode.buildRoot();
        //根节点的子节点列表
        List<MyTreeNode> rootChildren = new ArrayList<>();
        //将评论封装为树的节点
        List<MyTreeNode> nodes = new ArrayList<>();
        for (CommentVo comment : commentVoList) {
            MyTreeNode treeNode = MyTreeNode.buildNode(comment);
            nodes.add(treeNode);
        }
        for (MyTreeNode node : nodes) {
            MyTreeNode parentNode = findParentNode(node,nodes);
            if(parentNode != null){
                //不为空，说明有父节点
                if(parentNode.getChildren() == null){
                    //说明这个节点是父节点的第一个子节点，创建一个子节点数组
                    List<MyTreeNode> children=new ArrayList<>();
                    children.add(node);
                    parentNode.setChildren(children);
                }else{
                    parentNode.getChildren().add(node);
                }
            }else{
                //为空，说明父节点为根节点
                //父节点添加子节点
                rootChildren.add(node);
                //子节点添加父节点id
                node.setParentId(root.getId());
            }
            root.setChildren(rootChildren);
        }

        return root;
    }

    /**
     * description: 找到子节点的父节点
     *
     * @param childNode:
     * @param allNodes:
     * @return MyTreeNode
     * @author 胡建华
     * Date:  2022/10/19 20:23
     */
    public MyTreeNode findParentNode(MyTreeNode childNode,List<MyTreeNode> allNodes){
        for (MyTreeNode node : allNodes) {
            if(childNode.getParentId().equals(node.getId())){
                //将子评论的内容添加到父评论的children列表中。
                //如果父评论(CommentVo)的子评论列表为null,则新建一个列表。
                List<CommentVo> fatherCommentList = node.getContent().getChildren();
                if(fatherCommentList == null){
                    fatherCommentList = new ArrayList<>();
                    fatherCommentList.add(childNode.getContent());
                    node.getContent().setChildren(fatherCommentList);
                }else{
                    node.getContent().getChildren().add(childNode.getContent());
                }
                //添加此节点的父亲节点
                childNode.setParentId(node.getId());
                return node;
            }
        }
        return null;

    }

    /**
     * description: 获取权限树的子节点
     *
     * @param id:
     * @param menuList:
     * @return List<Menu>
     * @author 胡建华
     * Date:  2022/10/29 15:04
     */
    public List<Menu> getChildTree(Integer id, List<Menu> menuList) {
        List<Menu> childList = new ArrayList<>();
        // 循环获取子节点
        menuList.forEach(menu -> {
            if (menu.getParentId() != null){
                if (menu.getParentId().equals(id) && menu.getLevel() > 1) {
                    childList.add(menu);
                }
            }
        });
        // 获取子节点的子节点
        childList.forEach(menu -> {
            // 递归获取子节点
            List<Menu> childTree = this.getChildTree(menu.getMenuId(), menuList);
            if (childTree.size() > 0) {
                menu.setChildren(childTree);
            }
        });
        return childList;
    }
}
