package com.atguigi.my.linkedList;

import java.util.Stack;

/**
 * @ProjectName: DataStructures
 * @Package: com.atguigi.my.linkedList
 * @ClassName: SingleLinkedListDemo
 * @Author: chenzhen
 * @Description: 单链表学习
 * @Date: 2019/12/14 0014 下午 9:44
 * @Version: 1.0
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
//        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");

        HeroNode hero5 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(4, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(6, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");

        //创建要给链表
        SingleLinkeList singleLinkedList = new SingleLinkeList();

        SingleLinkeList singleLinkedList1 = new SingleLinkeList();

        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);

//        singleLinkedList1.addByOrder(hero5);
//        singleLinkedList1.addByOrder(hero6);
//        singleLinkedList1.addByOrder(hero7);
        singleLinkedList1.addByOrder(hero8);

        SingleLinkeList newList = mergeLinkedList(singleLinkedList, singleLinkedList1);


        newList.list();



//        singleLinkedList.list();

//        System.err.println("-----------------");
//
//        HeroNode hero5 = new HeroNode(3,"xxxxxxxxxx","yyyyyyyy");
//        singleLinkedList.update(hero5);
//
//        singleLinkedList.list();
//        singleLinkedList.del(3);
//        singleLinkedList.list();
//        singleLinkedList.addByOrder(hero3);
//        System.err.println("---------");
//        singleLinkedList.list();

        // 测试统计node的长度(传入的是头节点，头节点不统计)
//        System.out.println("node1 的长度是： " + size(hero1));//3
//        System.out.println("node2 的长度是： " + size(hero2));//2
//        System.out.println("node3 的长度是： " + size(hero3));//1
//        System.out.println("node4 的长度是： " + size(hero4));//0

//        HeroNode lastIndex = findLastIndex(hero1, 2);
//        HeroNode lastIndex = findLastIndex(hero1, 3);
//        System.err.println("hero1 的 倒数第二个的节点是 " + lastIndex);

//        singleLinkedList.list();
//        System.err.println();
//        System.err.println("================");
//        reverseList(singleLinkedList.getHead());
//        singleLinkedList.list();
//
//        reversePrint(singleLinkedList.getHead());





    }

    /**
     * 问题：获取单链表的节点个数，如果是带头结点的链表，不需要统计头结点
     * @param head 链表的头部
     */
    public static int size(HeroNode head){
        // 创建临时变量代替指针、链表长度计数器
        HeroNode temp = head.getNext();
        int length = 0;
        // 判断链表是否为空
        if (temp == null){
            return 0;
        }
        while (temp != null){
            length++;
            temp = temp.getNext();
        }
        return length;
    }

    //查找单链表中的倒数第k个结点 【新浪面试题】
    //思路
    //1. 编写一个方法，接收head节点，同时接收一个index
    //2. index 表示是倒数第index个节点
    //3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //4. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //5. 如果找到了，则返回该节点，否则返回null
    public static HeroNode findLastIndex(HeroNode head, int index){
        // 1.判断 如果链表为空，直接返回null
        if (head.getNext() == null){
            return null;
        }
        // 第一次遍历得到链表的长度
        int length = size(head);
        // 第二次遍历，size - index位置，就是我们需要查找的第k个节点
        // index 校验合法性
        if (index <= 0 || index > length){
            return null;
        }
        // 定义一个辅助指针，便于遍历
        HeroNode temp = head.getNext();
        for (int i = 0; i < (length - index); i++){
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * 将单链表反转
     * 思路：
     *      1.判断当前头节点有几个节点，若空链表或是只有一个节点，直接返回；
     *      2.若 1 不满足,定义一个新的头节点；
     *      3.遍历node中每一个节点，从前到后逐一插入新建头节点的next
     *      4.将head的next指向新建的头节点的下一个节点
     * @param node
     */
    public static void reverseList(HeroNode node){
        // 1.判断空链表 或是 一个节点的链表
        if (node.getNext() == null || node.getNext().getNext() == null){
            return;
        }
        // 2.定义一个新的头节点
        HeroNode reverse = new HeroNode(-1,"","");
        // 3.定义一个辅助变量指向当前节点，定义一个节点指向当前节点的下一个节点
        HeroNode temp = node.getNext();
        HeroNode next = null;
        while (temp != null){
            next = temp.getNext();// 保留当前节点的下一个节点
            // 将当前节点的next指向新头节点的next节点
            temp.setNext(reverse.getNext());
            // 将新头节点的next指向当前节点
            reverse.setNext(temp);
            // 将当前节点后移
            temp = next;
        }
        // 4.将链表头节点的next指向新头节点的next
        node.setNext(reverse.getNext());
    }

    // 反向打印单链表
    // 思路一：将链表反转，遍历(破坏了原有的数据结构)
    // 思路二：利用栈的特性，将链表依次压入栈中，然后打印栈元素
    public static void reversePrint(HeroNode head){
        // 链表判空,为空则直接返回，不打印
        if (head.getNext() == null){
            System.err.println("空链表，没有数据");;
            return;
        }
        // 定义Stack存储链表元素
        Stack<HeroNode> stack = new Stack<>();

        // 定义临时指针辅助遍历
        HeroNode temp = head.getNext();
        while (temp != null){
            stack.add(temp);
            // 指针后移
            temp = temp.getNext();
        }
        // 打印栈元素
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    // 课后练习
    // 将两个有序链表合并成一个有序链表
    public static SingleLinkeList mergeLinkedList(SingleLinkeList list1, SingleLinkeList list2){
        // 获取链表头
        HeroNode head1 = list1.getHead();
        HeroNode head2 = list2.getHead();

        // 判断链表是否为空
        if (head1.getNext() == null && head2.getNext() == null){
            System.err.println("两个链表数据为空");
            return null;
        }

        //定义新的单链表
        SingleLinkeList newList = new SingleLinkeList();

        // 定义head1、head2、新头结点的临时指针
        HeroNode temp1 = head1.getNext();
        HeroNode temp2 = head2.getNext();
        HeroNode temp = null;

        // 当两个都存在的时候，比较，并放在队尾
        while (temp1 != null && temp2 != null){
            if (temp1.getNo() < temp2.getNo()){
                temp = temp1;
                temp1 = temp1.getNext();
            }else{
                temp = temp2;
                temp2 = temp2.getNext();
            }
            temp.setNext(null);
            newList.add(temp);
        }

        // 当一个链表结束后
        while (temp1 != null){
            temp = temp1;
            temp1 = temp1.getNext();
            // 添加元素
            temp.setNext(null);
            newList.add(temp);
        }

        while (temp2 != null){
            temp = temp2;
            temp2 = temp2.getNext();
            // 添加元素
            temp.setNext(null);
            newList.add(temp);

        }
        return newList;
    }



}

/**
 * 单链表类
 *      主要方法：增（有序添加和无序添加）删改查方法和遍历
 */
class SingleLinkeList{

    /**
     * 头节点，没有具体数据，指向第一个节点的指针
     */
    private HeroNode head;

    /**
     * 构造器，初始化头节点
     */
    public SingleLinkeList(){
        this.head = new HeroNode(-1, "","");
    }

    /**
     * head的get方法，不提供set方法
     * @return
     */
    public HeroNode getHead() {
        return this.head;
    }

    //添加节点到单项列表
    //思路1：当不考虑顺序时
    //1.找到当前链表的最后一个节点
    //2.将最后一个节点的next指向新的节点

    /**
     * 添加节点，不考虑顺序，直接将节点添加到最后
     * @param node
     */
    public void add(HeroNode node){
        // 1.定义一个临时变量保存节点，因为head节点不能动
        HeroNode temp = head;
        while (true){
            //2.找到当前链表的最后
            if (temp.getNext() == null){
                // 3.跳出循环
                break;
            }
            // 依次遍历每一个节点
            temp = temp.getNext();
        }
        // 当退出while循环时,temp就指向了链表的最后
        // 将这个节点的next指向新的节点
        temp.setNext(node);
    }

    /**
     * 第二种方法，在添加英雄时，根据英雄排名，插入到指定位置
     * 如果这个排名存在，则添加失败，并给出提示
     */
    public void addByOrder(HeroNode node){
        // 头节点不能动,需要设置一个临时变量作为辅助指针
        // 由于是单链表, 我们需要找到添加节点的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;// flag表示节点编号是否存在

        while (true){
            // 只有头节点，表示目前没有数据
            if (temp.getNext() == null){
                break;
            }
            // 找到插入节点的上一个节点
            if (temp.getNext().getNo() > node.getNo()){//位置已找到 temp即是要插入元素对应的上一个节点
                break;
            }else if (temp.getNext().getNo() == node.getNo()){
                flag = true;//编号已存在
                break;
            }
            // 向后移动，继续遍历
            temp = temp.getNext();
        }
        if (!flag){
            // 将插入节点的 next 指向临时节点的下一个节点
            node.setNext(temp.getNext());
            // 将临时节点的 next 指向插入节点
            temp.setNext(node);
        }else{
            System.err.printf("当前编号 %d 的英雄已存在，不要多次插入", node.getNo());
            System.out.println();
        }
    }

    // 修改节点的信息，根据no编号来修改，但是no不能改
    // 说明
    // 1.根据 node 的 no来修改
    public void update(HeroNode node){
        // 1.判断链表是否为空
        if (head.getNext() == null){
            System.err.println("链表为空");
            return;
        }
        // 定义一个辅助指针
        HeroNode temp = head.getNext();
        // 判断是否找到该节点
        boolean flag = false;
        while (true){
            // 已经遍历完列表
            if (temp == null){
                break;
            }
            // 找到要修改的数据
            if (temp.getNo() == node.getNo()){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            temp.setName(node.getName());
            temp.setNickName(node.getNickName());
        } else {
            System.err.printf("没有找到编号为 %d 的节点", node.getNo());
        }
    }

    // 根据 no 删除节点
    // 思路
    // head节点不能动，需要一个辅助节点作为辅助指针
    // 需要找到要删除节点的上一个节点
    public void del(int no){
        if (head.getNext() == null){
            System.err.println("链表为空");
            return;
        }
        // 创建辅助节点
        HeroNode temp = head.getNext();
        boolean flag = false;
        while (true){
            if (temp.getNext() == null){
                break;
            }
            if (temp.getNext().getNo() == no){
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag){
            // 将要删除节点的上一个节点的指针指向要删除节点的下一个节点
            temp.setNext(temp.getNext().getNext());
        }else{
            System.err.printf("没有编号为 %d 的英雄");
        }

    }



    /**
     * 遍历链表
     */
    public void list(){
        // 判断当前链表是否为空
        if (head.getNext() == null){
            System.err.println("链表控,没有数据");
            return;
        }
        // 设置临时变量代替指针
        HeroNode temp = head.getNext();
        while (true){
            // 判断链表是否到最后: 即临时变量是否为空
            if (temp == null){
                break;
            }
            // 输出当前节点的信息
            System.out.println(temp);
            // 指针后移
            temp = temp.getNext();
        }
    }



}


/**
 * 节点类
 */
class HeroNode{
    /**
     * 排名
     */
    private int no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 指向下一个节点
     */
    private HeroNode next;

    /**
     * 构造器
     * @param no
     * @param name
     * @param nickName
     */
    public HeroNode(int no, String name, String nickName){
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

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }
//
//    @Override
//    public String toString() {
//        return "HeroNode{" +
//                "no=" + no +
//                ", name='" + name + '\'' +
//                ", nickName='" + nickName + "}";
//    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                '}';
    }
}
