package com.thunisoft.test.my;

public class ThreadPoolFieldTest {

    public static void main(String[] args) {

//        powTest();
        final int COUNT_BIT = Integer.SIZE - 3;
//        System.out.println(COUNT_BIT);
        System.err.println(Integer.toBinaryString(COUNT_BIT));

        final int COUNT_MASK = (1 << COUNT_BIT) - 1;
//        final int COUNT_MASK = (1 << COUNT_BIT);
//        System.out.println(COUNT_MASK);
        System.err.println(Integer.toBinaryString(COUNT_MASK));


        System.out.println(Integer.toBinaryString(COUNT_BIT ^ COUNT_BIT));


    }

    private static void powTest() {
        System.out.println(Integer.toBinaryString(2 ^ 29));
        System.out.println(2 ^ 29);

        System.out.println((int)Math.pow(2,3));
    }


}
