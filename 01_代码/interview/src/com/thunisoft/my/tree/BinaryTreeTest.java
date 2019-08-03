package com.thunisoft.my.tree;

/**
 * @author chenzhen-1
 * @create 2019-06-17 16:09
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树： 数组实现二叉树
 *  创建一个深度为10的二叉树
 */
public class BinaryTreeTest {


    public static void main(String[] args) {
        BinaryTree<Character> bt = new BinaryTree(getChars());
        Object[] arr = bt.getArray();

//        for (Object cha: arr) {
////            System.out.print(cha + "\t");
////        }
//        Object[] subTree = bt.getSubTree(6);
//
//        for (Object obj: subTree) {
//            System.out.println(obj);
//        }

//        bt.preorder(0);
//        bt.inorder(0);
        bt.afterorder(0);


    }



    /**
     * 测试数组
     * @return
     */
    public static Character[] getChars(){
        Character[] cs = new Character[26];
        for(int i = (int)'A'; i <= (int)'Z'; i++){
            if ( i % 4 == 0){
                continue;
            }
            cs[i - (int)'A'] = (char)i;
        }
        return cs;
    }


    /**
     * 数组移位
     * @param objs
     */
    public static void notNull(Object[] objs){
        for (int i = 0; i < objs.length - 1; i++) {
            if (objs[i] == null){
                for (int j = i; j < objs.length - 2; j++){
                    objs[j] = objs[j + 1];
                }
                objs[objs.length - 1] = null;
            }
        }
    }


}

/**
 *  二叉树类
 *      数组实现
 *
 */
class BinaryTree<T>{

    /**
     * 二叉树深度
     */
    private int deep;

    /**
     * 数组长度
     */
    private int len;

    /**
     * 根节点：数组的第一位
     */
    private Object root;

    /**
     * 二叉树数组
     */
    private Object[] array;

    /**
     * 子树
     */
    private List<Object> subTree;

    /**
     * 无参构造器
     */
    public BinaryTree() {
       // 创建默认深度10的二叉树
        this.deep = 10;
        // 根据二叉树性质，最大节点数=2^n - 1
        this.len = (int)(Math.pow(2,deep) - 1);
        // 设置二叉树根节点（数据第一个元素为1）
        array[0] = 1;
        this.root = array[0];
        this.subTree = new ArrayList(this.len / 2);
    }

    /**
     *
     * @param deep: 二叉树深度
     * @param root: 根节点
     */
    public BinaryTree(int deep, T root) {
        this.array[0] = root;
        this.root = root;
        this.deep = deep;
        this.len = (int) (Math.pow(2, deep) - 1);
        //创建一个数组来存储这个
        this.array = new Object[len - 1];
        this.subTree = new ArrayList(this.len / 2);
    }


    /**
     * 根据传入的数组创建二叉树
     * @param arr
     */
    public BinaryTree(T[] arr){
        this.root = arr[0];
        this.len = arr.length;
        this.notNull(arr);
        this.array = arr;
        for (int i = 0; i < this.len; i++) {
            array[i] = arr[i];
            if( 2 * i + 1 < this.len){
                array[2 * i + 1] = arr[2 * i + 1];
            }
            if( 2 * i + 2 < this.len){
                array[2 * i + 2] = arr[2 * i + 2];
            }
        }
        this.subTree = new ArrayList(this.len / 2);
    }


    /**
     * 数组移位
     * @param objs
     */
    public void notNull(Object[] objs){
        int temp = 0;
        for (int i = 0; i < objs.length - 1 - temp; i++) {
            if (objs[i] == null){
                for (int j = i; j < objs.length - 1; j++){
                    objs[j] = objs[j + 1];
                }
                ++temp;
//                System.out.println(temp);
                objs[objs.length - temp] = null;
            }
        }
    }


    /**
     * 获取子树对外暴露的方法
     * @param index
     * @return
     */
    public Object[] getSubTree(int index){
        if (index < 0 || index >= this.len){
            throw new IllegalArgumentException("输入参数不合法!");
        }
        if (this.array[index] ==  null){
            return new Object[]{};
        }
        subTree.add(array[index]);
        return this.getSubTree(index, this.subTree);
    }
    /**
     * 获取子树
     * @param index
     * @return
     */
    public Object[] getSubTree(int index,List<Object> subTree){
        if (2 * index + 1 < this.len && array[2 * index + 1] != null){
            subTree.add(array[2 * index + 1]);
            getSubTree(2 * index + 1,subTree);
        }
        if (2 * index + 2 < this.len&& array[2 * index + 2] != null){
            subTree.add(array[2 * index + 2]);
            getSubTree(2 * index + 2,subTree);
        }
        return subTree.toArray();
    }


    /**
     * 前序遍历二叉树
     * @param index
     */
    public void preorder(int index){
        if(this.array[index] != null){
            System.out.println(array[index]);
            if (index * 2 + 1 < this.len){
                preorder(index * 2 + 1);
            }
            if (index * 2 + 2 < this.len){
                preorder(index * 2 + 2);
            }
        }
    }
    /**
     * 中序遍历二叉树
     * @param index
     */
    public void inorder(int index){
        if(this.array[index] != null){
            if (index * 2 + 1 < this.len){
                inorder(index * 2 + 1);
            }
            System.out.println(array[index]);
            if (index * 2 + 2 < this.len){
                inorder(index * 2 + 2);
            }
        }
    }
    /**
     * 后序遍历二叉树
     * @param index
     */
    public void afterorder(int index){
        if(this.array[index] != null){
            if (index * 2 + 1 < this.len){
                afterorder(index * 2 + 1);
            }
            if (index * 2 + 2 < this.len){
                afterorder(index * 2 + 2);
            }
            System.out.println(array[index]);
        }
    }


    /**
     * 设置某一节点的子节点
     * @param index
     * @param value
     * @param isLeft
     */
    public void setChild(int index, T value, boolean isLeft){
        if (index >= len || index < 0){
            System.out.println("下标不合法");
            return;
        }
        if (array[index] == null){
            System.out.println("该节点为空，不能创建子树");
            return;
        }
        if (isLeft && 2 * index  + 1 < this.len){
            array[2 * index + 1] = value;
            return;
        }
        if (!isLeft && 2 * index  + 2 < this.len){
            array[2 * index + 2] = value;
            return;
        }
        System.out.println("输入下标不合法！");
    }



    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public Object getRoot() {
        return root;
    }

    public void setRoot(T root) {
        this.root = root;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}
