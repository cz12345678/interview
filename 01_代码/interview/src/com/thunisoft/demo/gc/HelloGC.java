package com.thunisoft.demo.gc;

import static java.lang.Integer.MAX_VALUE;

/**
 * @author chenzhen-1
 * @create 2019-06-07 15:04
 */

/**
 * 在运行时配置开启打印GC详细信息的参数
 *      -XX:+PrintGCDetails
 *      -XX:-PrintGCDetails
 *  查看元空间大小：
 *         jinfo -flag MetaspaceSize java进程号
 *  设置元空间大小：
 *          -XX：MetaspaceSize=1024m
 */
public class HelloGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("XxxxxxxxxxxxxxxxxxxxxxHello Gc)))))))))");
        try {
            Thread.sleep(MAX_VALUE);
        } catch (InterruptedException e) {
        }
    }


}
