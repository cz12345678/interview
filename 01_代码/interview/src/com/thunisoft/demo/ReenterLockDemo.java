package com.thunisoft.demo;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock中只要lock与unlock匹配，都可以执行成功（加几次锁，解几次锁）
 */
class ReDemo implements Runnable{

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    /**
     * 第一层锁
     */
    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t invoke get method");
            set();
        }
        finally{
            lock.unlock();
        }

    }

    /**
     * 第二层锁
     */
    public void set(){
        lock.lock();
//        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t ############invoke set method");
        }
        finally {
            lock.unlock();
//            lock.unlock();
        }
    }


}



class Phone{

    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getName() + "\t invoke sendSMS()" );
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getName() + "\t #############invoke sendEmail()" );
    }

}

/**
 * @author chenzhen-1
 * @create 2019-06-01 15:16
 */
public class ReenterLockDemo {

    public static void main(String[] args) {
        //synchronized 的可重入锁演示
//        syncDemo();
        lockDemo();


    }

    /**
     * 运行结果：
     *      Thread-0	 invoke get method
            Thread-0	 ############invoke set method
            Thread-1	 invoke get method
            Thread-1	 ############invoke set method
     */
    private static void lockDemo() {
        ReDemo reDemo = new ReDemo();
        new Thread(reDemo).start();
        new Thread(reDemo).start();
    }

    /**
     * Synchroinized 结果：
         t1	 invoke sendSMS()
         t1	 #############invoke sendEmail()
         t2	 invoke sendSMS()
         t2	 #############invoke sendEmail()
     */
    private static void syncDemo() {
        Phone phone = new Phone();

        new Thread(() -> {
            phone.sendSMS();
        },"t1").start();


        new Thread(() -> {
            phone.sendSMS();
        },"t2").start();
    }
}
