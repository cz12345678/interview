package com.thunisoft.test.list2array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List2ArrayTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        String[] strs = new String[2];

        String[] strs1 = list.toArray(strs);

        System.out.println(Arrays.asList(strs));
        System.out.println(Arrays.asList(strs1));

        System.out.println("---------------------------------");

        String[] str2 = new String[3];

        list.toArray(str2);

        System.out.println(Arrays.asList(str2));


        System.out.println("-------------------------------");

        String[] str3 = new String[5];

        list.toArray(str3);

        System.out.println(Arrays.asList(str3));

    }

}
