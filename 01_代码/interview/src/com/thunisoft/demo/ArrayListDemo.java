package com.thunisoft.demo;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author chenzhen-1
 * @create 2019-05-31 15:35
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        /**
         * 线程不安全的：ArrayList Set HashMap
         * 线程安全的：CopyOnWriteArrayList  CopyOnWriterArraySet ConcurrentHashMap
         */
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        List<String> list = new ArrayList<String>();
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
             new Thread(() -> {
                 list.add(UUID.randomUUID().toString().substring(0,10));
                 System.out.println(list);
             },String.valueOf(i)).start();
        }

    }
    /**
     * 1.故障现象
     *      java.util.ConcurrentModificationException
     *
     *
     * 2.导致原因
     *      并发争抢修改导致，参考我们的花名册签名情况。
     *      一个人正在写入，另外一个同学过来争抢，导致数据不一致异常。并发修改异常。
     *
     *
     * 3.解决方案
     *      3.1 使用Vector
     *      3.2 Collections.synchronizedList(new ArrayList<>())
     *      3.3 JUC CopyOnWriterArrayList
     *
     *
     * 4.优化建议（同样的错误不犯第2次）
     *
     *
     *
     */

}
