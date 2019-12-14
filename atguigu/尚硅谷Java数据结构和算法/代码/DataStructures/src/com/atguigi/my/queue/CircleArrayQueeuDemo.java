package com.atguigi.my.queue;

import java.util.Scanner;

public class CircleArrayQueeuDemo {

    public static void main(String[] args) {

        //测试一把
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArrayQueue queue = new CircleArrayQueue(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

}

/**
 *@Description 唤醒数组队列
 *@author  chenzhen-1
 *@time  2019/12/14-11:25
 */
class CircleArrayQueue{

    /** 表示数组最大容量，队列的最大容量 maxSize - 1    */
    private int maxSize;

    /** 队头，指向队列的第一个元素    */
    private int front;

    /** 队尾，指向队列最后一个元素的后一个位置,预留出来一个位置作为约定   */
    private int rear;

    /** 存储数据的数组，模拟队列    */
    private int[] arr;

    /**
     *@Description 环形数组队列构造器，出入数组的初始化容量
     *@author  chenzhen-1
     *@time  2019/12/14-11:30
     */
    public CircleArrayQueue(int maxSize){
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    /**
     *@Description 判断队列已满，即队尾指针的下一个元素是不是队头指针对应的元素
     *@author  chenzhen-1
     *@time  2019/12/14-11:34
     */
    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }

    /**
     *@Description 判断队列是否为空，首尾指针重合
     *@author  chenzhen-1
     *@time  2019/12/14-11:36
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     *@Description 添加元素到队列中
     * 注意点：赋值下标、队尾移动
     *@author  chenzhen-1
     *@time  2019/12/14-11:37
     */
    public void add(int value){
        // 1.判断队列是否已满
        if (isFull()){
            System.err.println("队列满，不能加入数据");
            return;
        }
        // 2.赋值
        arr[rear] = value;

        // 3.队尾指针后移
        rear = (rear + 1) % maxSize;
    }

    /**
     *@Description 获取队列中的数据，出队列
     *@author  chenzhen-1
     *@time  2019/12/14-11:41
     */
    public int getQueue(){
        // 1.判断队列是否为空
        if (isEmpty()){
            throw  new RuntimeException("队列空，不能取数据");
        }
        // 2.取出数据
        int value = arr[front];

        // 3.队头移位
        front = (front + 1) % maxSize;

        return value;
    }

    /**
     *@Description 获取队列的长度
     * 注意： 可以自己试验一下
     *@author  chenzhen-1
     *@time  2019/12/14-11:50
     */
    public int size(){
        return (rear - front + maxSize) % maxSize;
    }

    /**
     *@Description 显示队列的所有数据
     *@author  chenzhen-1
     *@time  2019/12/14-11:52
     */
    public void showQueue(){
        // 1. 判断队列是否为空
        if (isEmpty()){
            System.err.println("队列空，没有数据");
            return;
        }
        // 2. 遍历，注意 front 和 rear 和 结束循环的条件

        for (int i = front; i < front + size(); i++){
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }

    }

    /**
     *@Description 获取队列头数据
     *@author  chenzhen-1
     *@time  2019/12/14-13:38
     */
    public int headQueue(){
        // 1. 判断队列是否为空
        if (isEmpty()){
            System.err.println("队列空，没有数据");
        }
        // 返回front处的数据
        return arr[front];
    }

}