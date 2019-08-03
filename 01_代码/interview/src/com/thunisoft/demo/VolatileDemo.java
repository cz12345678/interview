package com.thunisoft.demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzhen-1
 * @create 2019-05-29 10:09
 *
 * 1.验证volatile的可见性
 *  1.1 假如 int number = 0； number变量之前根本没有添加volatile关键字修饰*
 *  1.2 添加了volatile，可以解决可见性问题
 *
 *
 * 2.验证volatile不保证原子性
 *  2.1 原子性值得是什么意思？
 *      不可分割，完整性，也即某个线程正在做某个具体业务是，中间不可以被加塞或被分割。需要整体完整，要么同时成功，要么同时失败。
 *
 *  2.2 案例演示
 *
 *  2.3 why
 *
 *  2.4 如何解决原子性
 *      * 加sync
 *      * 使用我们JUC下AtomicInteger
 *
 */
public class VolatileDemo {


    public static void main(String[] args) {
        MyData myData = new MyData();

        //20个线程，每个线程调用1000次，正常情况下计算结果应该是 20 * 1000，由于volatile不保证原子性，所以结果 <= 10 * 2000
        for (int i = 0; i < 20; i++) {
             new Thread(() -> {
                 for (int j = 0; j < 1000; j++) {
                     myData.addPlusPlus();
                     myData.addAtomic();
                 }

             },String.valueOf(i)).start();
        }
//        try{ TimeUnit.SECONDS.sleep(5);} catch(InterruptedException e){ e.printStackTrace();}

        //需要等待上面20个线程都全部计算完成后，再用main线程去的最终的结果值看是多少？
        while(Thread.activeCount() > 2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t finally number value : " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t finally number value : " + myData.atomicInteger);


    }

    /**
     * volatile 可以保证可见性，及时通知其他线程，主物理内存的值已经被修改。
     */
    private static void seeOkByVolatile() {
        MyData my = new MyData();//资源类

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in" );
            //暂停一会线程
            try{ TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){ e.printStackTrace();}
            my.addTo60();//修改数值
            System.out.println(Thread.currentThread().getName() + "\t update number value " + my.number);
         },"input thread name").start();

        //第二个线程：main线程
        while(my.number == 0){
            //main线程就一直在这里等待循环，知道number值不再等于零
        }

//        System.out.println(Thread.currentThread().getName() + "\t mission is over");
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value : " + my.number);
    }
}


class MyData{

//    int number = 0;
    volatile int number = 0;

    /**
     * 添加到60，可见性演示
     */
    public void addTo60(){
        this.number = 60;
    }

    /**
     * i++操作，不保证原子性演示（number前加了volatile修饰的）
     */
    public void  addPlusPlus(){
        number++;
    }


    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }



}

