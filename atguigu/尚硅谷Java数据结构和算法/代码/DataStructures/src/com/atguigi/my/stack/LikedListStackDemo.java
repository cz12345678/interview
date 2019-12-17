package com.atguigi.my.stack;

import java.util.Scanner;

public class LikedListStackDemo {


    public static void main(String[] args) {
        //测试一下ArrayStack 是否正确
        //先创建一个ArrayStack对象->表示栈
        LikedListStack stack = new LikedListStack();
        String key = "";
        boolean loop = true; //控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(new Node(value));
                    break;
                case "pop":
                    try {
                        Node res = stack.pop();
                        System.out.println(res.toString());
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");
    }



}


class LikedListStack{

    /**
     * top不保存数据，是栈的一个指针
     */
    private Node top;

    public LikedListStack(){
        this.top = new Node(-1);
    }

    // 判断 栈是否为空
    public boolean isEmpty(){
        if (top.getNext() == null){
            return true;
        }
        return false;
    }

    /**
     * 将数据添加到栈
     *      1.判断是否为空，如果为空，直接添加
     *      2.如果不为空，将新元素的next指向top的next，top的next指向新节点     *
     * @param node
     */
    public void push(Node node){
        if (isEmpty()){
            top.setNext(node);
            return;
        }
        node.setNext(top.getNext());
        top.setNext(node);
    }

    /**
     * 数据出栈
     *      1.判断栈是否为空，为空，给出提示并结束
     *      2.如果不为空，将top的next指向top的next的next
     * @return
     */
    public Node pop(){
        if (top.getNext() == null){
            throw new RuntimeException("栈空，没有数据");
        }
        Node temp = top.getNext();
        top.setNext(temp.getNext());
        return temp;
    }

    /**
     * 遍历栈
     */
    public void list(){
        if (top.getNext() == null){
            System.err.println("栈空，没有数据");
            return;
        }
        Node temp = top.getNext();
        while (temp != null){
            System.out.println(temp);
            temp = temp.getNext();
        }
    }


}


/**
 * 节点数据结构
 */
class Node{

    /** 存储数据信息    */
    private int value;

    /**  指向下一个节点    */
    private Node next;

    public Node(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}



