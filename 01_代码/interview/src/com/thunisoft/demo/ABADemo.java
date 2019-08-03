package com.thunisoft.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author chenzhen-1
 * @create 2019-05-31 14:11
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {


        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100,1);

         new Thread(() -> {
             //获取第一次版本号
            int stamp = stampedReference.getStamp();

            System.out.println(Thread.currentThread().getName() + "\t 第1次版本号： " + stamp);
            //暂停1秒钟t3线程
            try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){ e.printStackTrace();}

            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp() + 1);

             System.out.println(Thread.currentThread().getName() + "\t 第2次版本号： " + stampedReference.getStamp());

             stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp() + 1);

             System.out.println(Thread.currentThread().getName() + "\t 第3次版本号： " + stampedReference.getStamp());

         },"t3").start();


          new Thread(() -> {
              int stamp = stampedReference.getStamp();
              System.out.println(Thread.currentThread().getName() + "\t第一次版本号： " + stamp);
              //停留3秒，保证ABA操作
              try{ TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){ e.printStackTrace();}

              boolean result = stampedReference.compareAndSet(100,101,stamp,stampedReference.getStamp() + 1);

              System.out.println(Thread.currentThread().getName() + "\t 修改成功否： " + result + "\t 当前版本号是： " + stampedReference.getStamp());

              System.out.println("当前值是 ： " + stampedReference.getReference());

          },"t4").start();


    }

    private static void abaCase() {
        System.out.println("====================ABA 的问题的产生==========================");
        new Thread(() -> {
            //ABA问题线程
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();


        new Thread(() -> {
            try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){ e.printStackTrace();}
            System.out.println(atomicReference.compareAndSet(100,2019) + "\t" + atomicReference.get());
        },"t2").start();

        System.out.println("====================ABA 的问题的解决==========================");
    }

}
