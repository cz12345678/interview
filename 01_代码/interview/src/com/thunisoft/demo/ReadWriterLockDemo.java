package com.thunisoft.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{

    private volatile Map<String,Object> map = new HashMap<>();

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    /**
     * 写入数据： 线程独占
     * @param key
     * @param value
     */
    public void put(String key,Object value){

        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在写入 : " + key);
            try{ TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){ e.printStackTrace();}
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成 : "  + key);
        }finally {
            rwLock.writeLock().unlock();
        }

    }

    /**
     * 读取数据: 可共存
     * @param key
     */
    public void get(String key){

        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t 正在读取 : ");
            try{ TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){ e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成 : "  + result);
        }finally {
            rwLock.readLock().unlock();
        }

    }




}



/**
 * @author chenzhen-1
 * @create 2019-06-01 16:33
 *
 *
 *  读写锁：
 *      独占锁（写锁）
 *      共享锁（读锁）
 *      互斥锁
 *  多个线程同时读一个资源类没有问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 *  但是
 *  如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写
 *
 *  小总结：
 *      读-读共存
 *      读-写不能共存
 *      写-写不能共存
 *
 *
 */
public class ReadWriterLockDemo {

    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            },String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            },String.valueOf(i)).start();
        }


    }
}
