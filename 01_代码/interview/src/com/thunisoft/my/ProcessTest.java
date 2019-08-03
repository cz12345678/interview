package com.thunisoft.my;

/**
 * @author chenzhen
 * @create 2019-06-04 下午 9:09
 *
 * 查看硬件的处理器核数
 */
public class ProcessTest {

    public static void main(String[] args) {
        // 获取处理器核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
