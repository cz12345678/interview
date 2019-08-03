package com.thunisoft.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzhen-1
 * @create 2019-06-02 11:53
 *
 *
 * SynchronousQueue: 单个数据队列
 *      生产一个消费一个，类似于生产者消费者模式
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        // 线程1 模拟生产者
         new Thread(() -> {
             try {
                 System.out.println(Thread.currentThread().getName() + "\t put 1");
                 blockingQueue.put("1");

                 System.out.println(Thread.currentThread().getName() + "\t put 2");
                 blockingQueue.put("2");

                 System.out.println(Thread.currentThread().getName() + "\t put 3");
                 blockingQueue.put("3");
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"AAA").start();


         // 线程2 模拟消费者
         new Thread(() -> {
             try {
                 try{ TimeUnit.SECONDS.sleep(5);} catch(InterruptedException e){ e.printStackTrace();}
                 System.out.println(Thread.currentThread().getName() + "\t 消费了 " + blockingQueue.take() );

                 try{ TimeUnit.SECONDS.sleep(5);} catch(InterruptedException e){ e.printStackTrace();}
                 System.out.println(Thread.currentThread().getName() + "\t 消费了 "+ blockingQueue.take() );

                 try{ TimeUnit.SECONDS.sleep(5);} catch(InterruptedException e){ e.printStackTrace();}
                 System.out.println(Thread.currentThread().getName() + "\t 消费了 "+ blockingQueue.take() );

             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         },"BBB").start();

    }

}
