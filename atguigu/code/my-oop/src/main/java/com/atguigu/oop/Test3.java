package com.atguigu.oop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test3 {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(15));

        System.out.println(Integer.toBinaryString(256 ));

        int s = 15;
        s &= 256;

        System.out.println(Integer.toBinaryString(s));

        System.out.println(10 ^ (2));

        System.out.println(Math.pow(10, 3));

        List<String> list = Collections.unmodifiableList(Arrays.asList("zhangsan"));
        list.add("lisi");

    }

}
