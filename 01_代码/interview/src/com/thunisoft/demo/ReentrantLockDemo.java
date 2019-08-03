package com.thunisoft.demo;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyPrint{

    private int number = 1; // A:1  B:2  C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();



    public void print5(){
        lock.lock();
        try{
            //1 判断
            while(number != 1){
                c1.await();
            }
            //干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            //通知
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            //1 判断
            while(number != 2){
                c2.await();
            }
            //干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 3;
            //通知
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            //1 判断
            while(number != 3){
                c3.await();
            }
            //干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 1;
            //通知
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

/**
 * @author chenzhen-1
 * @create 2019-06-02 14:09
 *
 * 需求：
 *      多个线程之间顺序调用，实现A - B - C 三个线程启动，要求如下‘
 *      AA 打印5次，BB 打印10次，CC 打印15次
 *      紧接着
 *      AA 打印5次，BB 打印10次，CC 打印15次
 *      。。。
 *      来10轮
 *
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        MyPrint myPrint = new MyPrint();

        for (int i = 1; i <= 10 ; i++) {
            new Thread(() -> {
                myPrint.print5();
            },"AA").start();
            new Thread(() -> {
                myPrint.print10();
            },"BB").start();
            new Thread(() -> {
                myPrint.print15();
            },"CC").start();

        }

    }

}
