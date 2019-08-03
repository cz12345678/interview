package com.thunisoft.demo.ref;

import java.lang.ref.SoftReference;

/**
 * @author chenzhen-1
 * @create 2019-06-08 11:14
 */
public class SoftReferenceDemo {

    /**
     * JVM 配置，故意产生大对象并配置小的内存，让内存不够用产生OOM，看软引用的回收与情况
     *  -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_memory_NotEnough(){
        Object o1 = new Object();

        // 新建软引用，设置泛型，构造器传入对象
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        // 手动GC
        System.gc();

        try{
            byte[] bytes = new byte[30 * 1024 * 1024];
        }catch(Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }

    }


    /**
     * 内存足够用的时候就保留，不够用就回收
     */
    public static void softRef_memory_Enough(){

        Object o1 = new Object();

        // 新建软引用，设置泛型，构造器传入对象
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        // 手动GC
        System.gc();

        System.out.println(o1);
        System.out.println(softReference.get());


    }



    public static void main(String[] args) {

//        softRef_memory_Enough();

        softRef_memory_NotEnough();

    }
}
