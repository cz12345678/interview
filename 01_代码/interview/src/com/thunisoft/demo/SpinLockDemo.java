package com.thunisoft.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author chenzhen-1
 * @create 2019-06-01 16:08
 *
 * ================自旋锁==================
 *
 *
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    //上锁
    public void myLock(){
        //获取当前线程
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t is come in");
        // 期望线程引用中的线程为null，若为null，设置当前线程为引用值。设置成功后，返回true，取反false，跳出循环
        while(!atomicReference.compareAndSet(null,thread)){

        }

    }


    // 解锁
    public void unLock(){

        // 获取当前线程
        Thread thread = Thread.currentThread();
        // 判断当前线程与期望值是否一致，若一致，则置为null
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName() + "\t unLock .....");

    }


    /**
     * 结果为：
     *      AA	 is come in
            BB	 is come in
            AA	 unLock .....
            BB	 unLock .....
     * @param args
     */
    public static void main(String[] args) {

        SpinLockDemo spinLockDemo = new SpinLockDemo();

         new Thread(() -> {
             spinLockDemo.myLock();
             // 处理逻辑
             try{ TimeUnit.SECONDS.sleep(5);} catch(InterruptedException e){ e.printStackTrace();}
             // 逻辑处理完成，释放锁
             spinLockDemo.unLock();
         },"AA").start();

         // 保证AA线程先获得锁
         try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){ e.printStackTrace();}
         new Thread(() -> {
             spinLockDemo.myLock();
             // 处理逻辑
             try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){ e.printStackTrace();}
             // 逻辑处理完成，释放锁
             spinLockDemo.unLock();
         },"BB").start();


    }

}
