package com.thunisoft.test.switchtest;

import org.apache.commons.lang3.RandomUtils;

import java.util.Random;

/**
 * switch 在使用String类型作为参数时，不可为null，否则会报出空指针异常
 */
public class SwitchTest {

    public static void main(String[] args) {


        String str = null;



        new Random().nextInt();

        System.out.println("=============" + RandomUtils.nextInt(12,15));
        // switch 传 String 类型需要做非空校验
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
