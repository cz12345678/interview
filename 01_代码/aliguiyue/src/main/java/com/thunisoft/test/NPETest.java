package com.thunisoft.test;

/**
 * 空指针异常测试
 */
public class NPETest {

    public static void main(String[] args) throws Exception {
        Thread t = null;
        t.sleep(25L);

        System.out.println("GG");
//        Thread.sleep(5L);
    }
}
