package com.thunisoft.test;

public class ManyArgsTest {

    public static void main(String[] args) {

        testArgs(1,"a","b");

        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxx");

        String strs = "a,b,c,d,,";
        String[] split = strs.split(",");
        System.out.println(split.length);

    }

    public static void testArgs(Integer a ,String ... strs){
        System.out.println(strs.length);
        System.out.println(a);
    }

}
