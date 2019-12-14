package com.atguigi.my.linkedList;

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
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkeList singleLinkedList = new SingleLinkeList();

//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero4);

        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero1);

        singleLinkedList.list();

//        System.err.println("-----------------");
//
//        HeroNode hero5 = new HeroNode(3,"xxxxxxxxxx","yyyyyyyy");
//        singleLinkedList.update(hero5);
//
//        singleLinkedList.list();
//        singleLinkedList.del(3);
//        singleLinkedList.list();
        singleLinkedList.addByOrder(hero3);
        System.err.println("---------");
        singleLinkedList.list();

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName ;
    }
}
