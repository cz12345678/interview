package com.thunisoft.demo.ref;

import javax.sound.midi.SoundbankResource;
import java.lang.ref.WeakReference;

/**
 * @author chenzhen-1
 * @create 2019-06-08 11:27
 */
public class WeakRefDemo {

    /**
     * 弱引用，不管内存是否够用，只要有GC都会被回收
     * @param args
     */
    public static void main(String[] args) {
        Object o1 = new Object();

        WeakReference<Object> weakReference = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();

        System.out.println(o1);
        System.out.println(weakReference.get());

    }

}
