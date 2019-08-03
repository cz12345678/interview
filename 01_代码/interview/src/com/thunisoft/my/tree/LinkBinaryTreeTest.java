package com.thunisoft.my.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author chenzhen-1
 * @create 2019-06-18 17:51
 */
public class LinkBinaryTreeTest {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(15);

        tree.insert(new TreeNode(18));
        tree.insert(new TreeNode(16));
        tree.insert(new TreeNode(7));
        tree.insert(new TreeNode(6));
        tree.insert(new TreeNode(8));
        tree.insert(new TreeNode(22));
        tree.insert(new TreeNode(21));
        tree.insert(new TreeNode(25));
        tree.insert(new TreeNode(1));
        tree.insert(new TreeNode(10));
        tree.insert(new TreeNode(9));
        tree.insert(new TreeNode(5));
        tree.insert(new TreeNode(28));
        tree.insert(new TreeNode(26));
        tree.insert(new TreeNode(35));

//        System.out.println(tree);



//        tree.preOrderTree(tree);

        tree.inOrderTree(tree);
    }



}

class TreeNode{

    // 节点值
    private Integer value;

    // 左节点
    private TreeNode leftNode;

    // 右节点
    private TreeNode rightNode;

    // 根节点
//    private TreeNode root;


    public TreeNode(Integer value){
        this.value = value;
    }

    /**
     *  插入节点
     * @param node
     * @return
     */
    public boolean insert(TreeNode node){
        if (this.value == null){
            this.value = node.getValue();
            return true;
        }
        TreeNode current = this;
        while(current != null){
            if(current.getValue() == node.getValue()){
                return false;
            }
            if (node.getValue() > current.getValue()){
                if (current.getRightNode() == null){
                    current.setRightNode(node);
                    return true;
                }
                if(current.getRightNode() != null){
                    current = current.getRightNode();
                }
            }
            if (node.getValue() < current.getValue()){
                if (current.getLeftNode() == null){
                    current.setLeftNode(node);
                    return true;
                }
                if(current.getLeftNode() != null){
                    current = current.getLeftNode();
                }
            }
        }
        return false;
    }


    /**
     * 前序遍历二叉树
     */
    public void preOrderTree(TreeNode treeNode){
        if (treeNode != null){
            System.out.println(treeNode.getValue());
            preOrderTree(treeNode.getLeftNode());
            preOrderTree(treeNode.getRightNode());
        }
    }

    /**
     * 中序遍历二叉树
     * @param treeNode
     */
    public void inOrderTree(TreeNode treeNode){
        if(treeNode != null){
            inOrderTree(treeNode.getLeftNode());
            System.out.println(treeNode.getValue());
            inOrderTree(treeNode.getRightNode());
        }
    }

    /**
     * 后序遍历二叉树
     * @param treeNode
     */
    public void afterOrderTree(TreeNode treeNode){
        if(treeNode != null){
            inOrderTree(treeNode.getLeftNode());
            inOrderTree(treeNode.getRightNode());
            System.out.println(treeNode.getValue());
        }
    }


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}
