package com.thunisoft.demo.error;

/**
 * @author chenzhen-1
 * @create 2019-06-08 14:27
 */
public class StackOverFlowDemo {

    public static void main(String[] args) {
        staticOverFolwError();
    }

    private static void staticOverFolwError() {
        staticOverFolwError();// java.lang.StackOverflowError
    }

}
