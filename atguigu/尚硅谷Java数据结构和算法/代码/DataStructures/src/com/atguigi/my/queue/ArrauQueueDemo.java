package com.atguigi.my.queue;

import java.util.Scanner;

/**
 *@Description 数组模拟队列
 *@author  chenzhen-1
 *@time  2019/12/14-10:09
 */
public class ArrauQueueDemo {

    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.getHead();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
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




class ArrayQueue{

    /** 表示数组的最大容量    */
    private int maxSize;

    /** 队列头    */
    private int front;

    /** 队列尾    */
    private int rear;

    /** 存储队列元素的数组    */
    private int[] arr;


    /**
     *@Description 创建队列的构造器
     *@author  chenzhen-1
     *@time  2019/12/14-10:16
     */
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列的头部，front指向队列头的前一个位置
        rear = -1;// 指向队列尾，rear指向队列尾的数据
    }

    /**
     *@Description 判断队列是否已满
     *@author  chenzhen-1
     *@time  2019/12/14-10:19
     */
    public boolean isFull(){
        return rear == maxSize - 1; // 判断rear是否指向数组的最大下标
    }

    /**
     *@Description 判断队列是否为空
     *@author  chenzhen-1
     *@time  2019/12/14-10:22
     */
    public boolean isEmpty(){
        return rear == front;
    }

    /**
     *@Description 添加数据到队列中
     *@author  chenzhen-1
     *@time  2019/12/14-10:24
     */
    public void addQueue(int value){
        // 1.判断队列是否已满
        if (isFull()){
            System.err.println("-------队列已满-------");
            return;
        }
        // 2.队尾指针后移
        rear++;
        // 3.添加数据
        arr[rear] = value;
    }

    /**
     *@Description 从队列中获取数据，出队列
     *@author  chenzhen-1
     *@time  2019/12/14-10:26
     */
    public int getQueue(){
        // 1.判断队列是否为空
        if (isEmpty()){
            throw new RuntimeException("-------队列空，不能取数据-------");
        }
        // 2.队头指针后移
        front++;
        return arr[front];
    }

    /**
     *@Description 显示队列的所有元素
     *@author  chenzhen-1
     *@time  2019/12/14-10:52
     */
    public void showQueue(){
        if (isEmpty()){
            System.err.println("-------队列空，没有数据-------");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]= %d \t", i, arr[i]);
        }
    }

    /**
     *@Description 显示队列的头部，不取出数据
     *@author  chenzhen-1
     *@time  2019/12/14-10:55
     */
    public int getHead(){
        if (isEmpty()){
            throw new RuntimeException("-------队列空，没有数据-------");
        }
        return arr[front + 1];
    }
}
