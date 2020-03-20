package com.thunisoft.test.concurrent.pool;

import java.util.List;
import java.util.concurrent.*;

public class ArrayListTest {


    public static <T>void test(List<T> list){


    }

    private static List<String> list = new CopyOnWriteArrayList<>();

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            3, // 核心线程数
            5,// 最大线程数
            1L,// 等待时间
            // 等待时间单位
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<Runnable>(3),// 阻塞队列长度
            Executors.defaultThreadFactory(),// 线程工厂，用默认的就好
//                new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
//                new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略
//                new ThreadPoolExecutor.DiscardOldestPolicy()); // 拒绝策略
            new ThreadPoolExecutor.DiscardPolicy());

    public static void test(String[] args) {

        try{
            for (int i = 0; i < list.size(); i++){
                threadPool.execute(() ->{
                    // 处理业务逻辑
                });
            }
        }finally{
            threadPool.shutdown();
        }

    }



}
