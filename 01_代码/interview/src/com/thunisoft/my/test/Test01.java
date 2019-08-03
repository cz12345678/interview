package com.thunisoft.my.test;

/**
 * @author chenzhen-1
 * @create 2019-05-29 11:20
 *
 * 测试main方法运行是有几个有效线程在执行
 */
public class Test01 {

    public static void main(String[] args) {
        Test02 test = new Test02();

        System.out.println(Thread.activeCount());//2
    }

}
