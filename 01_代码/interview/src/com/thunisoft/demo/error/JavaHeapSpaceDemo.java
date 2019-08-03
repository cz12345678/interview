package com.thunisoft.demo.error;

import java.util.Random;

/**
 * @author chenzhen-1
 * @create 2019-06-08 14:32
 */
public class JavaHeapSpaceDemo {

    /**
     *  java.lang.OutOfMemoryError: Java heap space
     * @param args
     */
    public static void main(String[] args) {

        String str = "xxxxxxxxxx";

        while (true){
            str += str + new Random().toString();
        }

    }


}
