package com.thunisoft.demo.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author chenzhen-1
 * @create 2019-06-08 12:23
 */
public class PhantoReferenceDemo {

    public static void main(String[] args) {

        Object o1 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());//null
        System.out.println(referenceQueue.poll());// null
        System.out.println("========================================");

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(phantomReference.get());//null
        System.out.println(referenceQueue.poll());// 有值



    }

}
