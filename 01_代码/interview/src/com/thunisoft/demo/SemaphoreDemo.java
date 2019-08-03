package com.thunisoft.demo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzhen-1
 * @create 2019-06-02 10:26
 *
 *  信号灯：多个线程抢夺多个资源
 *      共享资源互斥
 *
 */
public class SemaphoreDemo {

    /**
     *  需求：六辆汽车，三个停车位
     * @param args
     */
    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(3);// 三个车位

        // 六辆汽车，停车
        for (int i = 1; i <= 6; i++) {

             new Thread(() -> {
                 try {
                     // 获取车位
                     semaphore.acquire();
                     System.out.println(Thread.currentThread().getName()  + "\t 抢到车位");
                     try{ TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){ e.printStackTrace();}
                     System.out.println(Thread.currentThread().getName() + "\t 停留3秒后，离开！");
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }finally {
                     // 车位释放
                     semaphore.release();
                 }

             },String.valueOf(i)).start();

        }

    }
}
