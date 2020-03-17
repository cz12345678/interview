package com.thunisoft.test;

import java.util.Arrays;
import java.util.List;

public class AsListTest {


    public static void main(String[] args) {

        String[] strs = new String[]{"huayu","zfw"};

        List<String> strings = Arrays.asList(strs);

//        strings.add("xxx"); //不支持操作验证

        System.out.println(strings);

        strs[0] = "yuandian";

        System.out.println(strings);

    }

}
