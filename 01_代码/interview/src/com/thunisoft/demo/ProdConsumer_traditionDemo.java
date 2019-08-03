package com.thunisoft.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{

    private int number = 0;

    // 获取锁
    private Lock lock = new ReentrantLock();

    // 条件
    private Condition condition = lock.newCondition();

    //加1 操作
    public void increment() throws Exception{

        lock.lock();
        try{
            // 判断(多线程环境下，判断要用while,防止虚假唤醒)
            while (number != 0){
                // 等待
                condition.await();
            }
            // 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number );
            // 通知唤醒
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
    //减1 操作
    public void decrement() throws Exception{

        lock.lock();
        try{
            // 判断(多线程环境下，判断要用while,防止虚假唤醒)
            while (number != 1){
                // 等待
                condition.await();
            }
            // 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number );
            // 通知唤醒
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }



}


/**
 * @author chenzhen-1
 * @create 2019-06-02 13:38
 * 题目：
 *      一个初始值为0的变量，两个线程对其交替操作，一个加1 一个减1，来五轮
 *
 *      1. 线程   操作  资源类
 *      2. 判断   干活  通知
 *      3. 防止虚假唤醒机制
 */
public class ProdConsumer_traditionDemo {

    public static void main(String[] args) throws Exception{

        ShareData shareData = new ShareData();

        // 线程1 ，加1操作，调用五次
         new Thread(() -> {
             try {
                 for (int i = 0; i < 5; i++) {
                     shareData.increment();
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"AA").start();
         new Thread(() -> {
             try {
                 for (int i = 0; i < 5; i++) {
                     shareData.decrement();
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"BB").start();
         new Thread(() -> {
             try {
                 for (int i = 0; i < 5; i++) {
                     shareData.increment();
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"CC").start();
         new Thread(() -> {
             try {
                 for (int i = 0; i < 5; i++) {
                     shareData.decrement();
                 }
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"DD").start();

    }


}
