package com.thunisoft.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {

//        classCastExceptionTest();

//        cmeTest();

        // 浅复制
        shadowCopyTest();


    }

    private static void shadowCopyTest() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        List<String> strings = list.subList(0, 2);

        System.out.println(strings);

        list.set(0,"b");

        System.out.println(strings);
    }

    // 高并发异常测试
    private static void cmeTest() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        List<String> strings = list.subList(0, 2);

        list.add("eee");

        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    // 类型转换异常测试
    private static void classCastExceptionTest() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");

        List<String> strings = list.subList(0, 2);
//        ArrayList<String> strings = (ArrayList)list.subList(0, 2);


        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println(strings);
    }

}
