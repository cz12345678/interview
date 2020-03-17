package com.thunisoft.test;

import java.util.ArrayList;
import java.util.List;

public class ForEachTest {

    public static void main(String[] args) {

//        forEachTest();

        cmeTest();

    }

    /**
     * 并发异常
     */
    private static void cmeTest() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

//        System.out.println(Thread.activeCount());


        for (String str: list) {

            if (str.equals("a")){
                list.remove(str);
            }
            System.out.println(str);
        }
    }

    // 遍历不完全

    /**
     * 如果删除倒数第二个元素，则会遍历不完全。
     */
    private static void forEachTest() {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        for (String str: list) {

            if (str.equals("d")){
                list.remove(str);
            }
            System.out.println(str);
        }
    }

}
