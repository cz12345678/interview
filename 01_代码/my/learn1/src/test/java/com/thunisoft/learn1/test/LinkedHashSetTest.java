package com.thunisoft.learn1.test;

import java.util.*;

/**
 * HashSet 内部存储无序，不能按照添加顺序存储
 * LinkedHashSet存储有序，按照添加顺序
 * TreeSet不能按照添加顺序打印，有自己的排序规则
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {

//        hashSetTest();
//        linkedHashSetTest();

        test(new HashSet<>());
        System.out.println();
        test(new LinkedHashSet<>());
        System.out.println();

        test(new TreeSet<>());


    }



    /**
     * 存储有序，按照添加顺序
     */
    private static void test(Set<String> set) {
//        Set<String> set = new LinkedHashSet<>();

        set.add("a");
        set.add("d");
        set.add("1");
        set.add("c");
        set.add("f");
        set.add("3");
        set.add("h");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.err.print(iterator.next() + "\t");
        }

    }

    /**
     * HashSet 内部存储无序，不能按照添加顺序存储
     */

}
