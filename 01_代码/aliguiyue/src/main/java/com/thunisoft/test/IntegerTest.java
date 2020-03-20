package com.thunisoft.test;

public class IntegerTest {

    public static void main(String[] args) {

        cacheTest();




    }

    private static void cacheTest() {
        Integer a = 1;

        Integer b = 1;

        System.out.println(a == b);

        Integer c = 1000;

        Integer d = 1000;

        System.out.println(c == d);
    }

}
