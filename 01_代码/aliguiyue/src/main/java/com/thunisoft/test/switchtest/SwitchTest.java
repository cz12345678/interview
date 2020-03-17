package com.thunisoft.test.switchtest;

/**
 * switch 在使用String类型作为参数时，不可为null，否则会报出空指针异常
 */
public class SwitchTest {

    public static void main(String[] args) {

        String str = null;

        switch (str) {
            case "a" :
                System.out.println("a");
                break;
            case "b" :
                System.out.println("b");
                break;
            default:
                System.out.println("default");
                break;
        }


    }

}
