package com.thunisoft.demo.thread;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 多线程实现1
 */
class MyThread3 extends Thread{

    @Override
    public void run() {
        super.run();
    }
}
/**
 * 多线程实现2
 */
class MyThread2 implements Runnable{

    @Override
    public void run() {

    }
}

/**
 * 多线程实现3
 *      get() 方法建议放在最后，要求获得Callable线程的计算结果，如果没有计算完成，会导致阻塞，直到计算完成
 */
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        System.out.println("****** ****call**************");
        System.out.println(Thread.currentThread().getName() + "\t come in.............");
        return 1024;
    }
}

/**
 * @author chenzhen-1
 * @create 2019-06-03 10:57
 *
 */
public class CallableDemo {

    public static void main(String[] args) throws Exception{

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());// 若是同一个FutureTask在不同的线程中，只会计算一次。计算结果可以复用
        FutureTask<Integer> futureTask2 = new FutureTask<>(new MyThread());

//        Thread t1 = new Thread(futureTask);
//        t1.start();

        new Thread(futureTask).start();
        new Thread(futureTask).start();

        while(!futureTask.isDone()){//判断是否算完，若算完，取反为false跳出线程。

        }
        System.out.println(futureTask.get());// get() 方法建议放在最后，要求获得Callable线程的计算结果，如果没有计算完成，会导致阻塞，直到计算完成

    }
}
