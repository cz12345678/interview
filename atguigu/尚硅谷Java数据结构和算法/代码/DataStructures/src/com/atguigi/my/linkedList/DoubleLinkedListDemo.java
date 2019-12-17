package com.atguigi.my.linkedList;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        DoubleLikedList list1 = getDoubleLikedList();
        list1.list();
//
//        Node node = new Node(0,"xxxxx","xxxxx");
//
//        list1.update(node);

//        list1.list();

//        System.err.println(list1.size());

//        System.err.println();
//
//        list1.delete(new Node(91,"xx","ee"));
//
//        list1.list();

    }

    /**
     * 获取双向链表List
     * @return
     */
    private static DoubleLikedList getDoubleLikedList() {
        Node node1 = new Node(1,"aaaa","aaaa");
        Node node2 = new Node(2,"bbbb","bbbb");
        Node node3 = new Node(3,"cccc","cccc");
        Node node4 = new Node(4,"dddd","dddd");
        Node node5 = new Node(5,"eeee","eeee");
        Node node6 = new Node(6,"ffff","ffff");
        Node node7 = new Node(7,"gggg","gggg");
        Node node8 = new Node(8,"hhhh","hhhh");
        Node node9 = new Node(9,"iiii","iiii");

        DoubleLikedList list1 = new DoubleLikedList();

        list1.addByOrder(node9);
        list1.addByOrder(node8);
        list1.addByOrder(node7);
        list1.addByOrder(node6);
        list1.addByOrder(node5);
        list1.addByOrder(node4);
        list1.addByOrder(node3);
        list1.addByOrder(node2);
        list1.addByOrder(node1);
        return list1;
    }

}


class DoubleLikedList{

    /**  链表的头部，不保存数据和编号，pre = null， next指向下一个节点   */
    private Node head;

    /**
     *@Description 获取头部的get方法
     *@author  chenzhen-1
     *@time  2019/12/16-14:00
     */
    public Node getHead() {
        return head;
    }

    /**
     * 构造器，初始化head
     */
    public DoubleLikedList(){
        head = new Node(-1,"","");
    }

    /**
     * 向双向链表中添加元素(添加到链表的最后)：
     *      1.找到最后一个元素，将改元素的next指向添加的元素
     *      2.将新添加元素的pre指向上一个元素
     * @param node
     */
    public void add(Node node){
        // head不能移动，需要一个辅助指针
        Node temp = this.head;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            temp = temp.getNext();
        }
        // 当退出while循环时，就找到了最后一个元素
        temp.setNext(node);
        node.setPre(temp);
    }

    /**
     *@Description 按照no大小插入到链表中
     *      需要注意，插入到队尾和队列中的区别
     *      需要特殊处理
     *@author  chenzhen-1
     *@time  2019/12/16-17:03
     */
    public void addByOrder(Node node){

        // 判断空链表，直接添加
        if (head.getNext() == null){
            head.setNext(node);
            node.setPre(head);
            return;
        }
        // head不能移动，设置一个辅助指针
        Node temp = head.getNext();
        Node next = null;
        while (true){
            // 判断节点是否已经存在，若存在，给出提示并返回
            if (temp.getNo() == node.getNo()){
                System.err.printf("改编号【%d】节点已存在", node.getNo());
                return;
            }
            // 判断插入节点是否插入到队尾(需要特别注意)
            if (temp.getNext() == null  ){
                if (temp.getNo() > node.getNo()){
                    next = temp;
                    temp = temp.getPre();
                }
                break;
            }

            // 节点需要添加到队中
            if (node.getNo() < temp.getNo()){
                next = temp;
                temp = temp.getPre();
                break;
            }
            temp = temp.getNext();
        }
        temp.setNext(node);
        node.setPre(temp);
        if (next != null){
            next.setPre(node);
            node.setNext(next);
        }
    }


    /**
     * 根据编号修改相对应的节点
     * @param node
     */
    public void update(Node node){
        // 判断链表是否为空
        if (head.getNext() == null){
            System.err.println("链表空！！！");
            return;
        }
        // 设置一个协助遍历的辅助指针
        Node temp = head.getNext();
        boolean flag = false;
        while (true){
            // 链表遍历完
            if (temp == null){
                break;
            }
            // 找到对应的节点
            if (temp.getNo() == node.getNo()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
        }else{
            System.err.printf("没有编号为【%d】的节点",node.getNo());
        }
    }

    /**
     *@Description 删除链表节点：
     *          判断是否是队尾元素
     *@author  chenzhen-1
     *@time  2019/12/16-17:20
     */
    public void delete(Node node){
        // 判空
        if (head.getNext() == null){
            System.err.println("链表空");
            return;
        }
        // 定义指针
        Node temp = head.getNext();

        boolean flag = false;

        while (temp != null){
            if (temp.getNo() == node.getNo()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            // 判断是否是队尾节点
            if(temp.getNext() == null){
                temp.getPre().setNext(null);
            }else{
                temp.getPre().setNext(temp.getNext());
                temp.getNext().setPre(temp.getPre());
            }

        }else{
            System.err.printf("没有这个编号【%d】的人员",node.getNo());
        }


    }
    

    /**
     *@Description 获取链表的长度
     *@author  chenzhen-1
     *@time  2019/12/16-17:14
     */
    public int size(){
        // 判空
        if (head.getNext() == null){
            return 0;
        }
        // 辅助指针，帮助遍历
        Node temp = head.getNext();
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    /**
     *@Description 遍历双向链表
     *@author  chenzhen-1
     *@time  2019/12/16-14:06
     */
    public void list(){
        // 判断链表是否为空
        if (head.getNext() == null){
            System.err.println("链表空！！！|");
            return;
        }
        // 定义辅助指针
        Node temp = head.getNext();

        // 遍历链表
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.getNext();
        }
    }


}

/**
 * 定义双向链表的节点类
 */
class Node{

    /** 编号，唯一    */
    private int no;

    /** 姓名    */
    private String name;

    /** 昵称    */
    private String nickName;

    /** 指向下一个节点    */
    private Node next;

    /** 指向上一个节点    */
    private Node pre;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickName
     */
    public Node(int no, String name, String nickName){
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}