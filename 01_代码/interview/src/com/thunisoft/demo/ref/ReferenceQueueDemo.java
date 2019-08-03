package com.thunisoft.demo.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author chenzhen-1
 * @create 2019-06-08 12:10
 */
public class ReferenceQueueDemo {

    public static void main(String[] args) {

        Object o1 = new Object();
        // 新建引用队列
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        // 新建若引用，将实体对象和引用队列传入
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());// 不会获得，只有在GC的时候才会被放入引用队列

        System.out.println("===================================");

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }
}
