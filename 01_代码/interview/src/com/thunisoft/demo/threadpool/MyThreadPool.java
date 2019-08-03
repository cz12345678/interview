package com.thunisoft.demo.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzhen-1
 * @create 2019-06-07 12:20
 */
public class MyThreadPool {

    public static void main(String[] args) {

        // cpu 核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        // 手写线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                3, // 核心线程数
                5,// 最大线程数
                1L,// 等待时间
                TimeUnit.SECONDS,// 等待时间单位
                new LinkedBlockingDeque<Runnable>(3),// 阻塞队列长度
                Executors.defaultThreadFactory(),// 线程工厂，用默认的就好
//                new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
//                new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略
//                new ThreadPoolExecutor.DiscardOldestPolicy()); // 拒绝策略
                new ThreadPoolExecutor.DiscardPolicy()); // 拒绝策略

        try{
            // 创建多个线程，访问线程池
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() + "\t 处理业务");
                    try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){ e.printStackTrace();}
                });
            }
        }finally {
            threadPool.shutdown();
        }



    }



}
