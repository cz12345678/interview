package com.thunisoft.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzhen-1
 * @create 2019-05-31 9:44
 *
 * 1. CAS是什么？
 *      Compare And Set 比较并交换
 *
 */
public class CASDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t value is : " + atomicInteger.get()  );

        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t value is : " + atomicInteger.get()  );

    }

}
