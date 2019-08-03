package com.thunisoft.my.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chenzhen
 * @create 2019-06-04 下午 9:30
 *
 *  // 使用池化技术必须关闭
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        // 一池固定数个线程
        ExecutorService fixPool = Executors.newFixedThreadPool(10);

        // 一池一个线程
        ExecutorService siglePool = Executors.newSingleThreadExecutor();


        // 一池多个线程
//        ExecutorService cachePool = Executors.newCachedThreadPool();

        try{
          fixPool.execute(()->{ System.out.println("xxxxxxxxxxxxxxxxxxxxxxx"); });// 无返回值
             Future<Integer> submit = fixPool.submit(() -> 300); // 有返回值
            System.out.println(submit.get());

        }catch(Exception e){

        }
        finally {

            // 不要忘记关闭池
            // 不要忘记关闭池
            // 不要忘记关闭池
            fixPool.shutdown();
//            siglePool.shutdown();
//            cachePool.shutdown();
        }
    }

}
