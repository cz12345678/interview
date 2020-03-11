package com.thunisoft.learn1.test;

/**
 * @ProjectName: learn1
 * @Package: com.thunisoft.learn1.test
 * @ClassName: VolatileTest
 * @Author: chenzhen
 * @Description: 查看volatile的字节码
 * @Date: 2020/3/11 0011 下午 10:31
 * @Version: 1.0
 */
public class VolatileTest {

    private static volatile VolatileTest instance = null;

    public static VolatileTest getInstance() {
        if (instance == null) {
            instance = new VolatileTest();
        }
        return instance;
    }

    public static void main(String[] args) {
        VolatileTest.getInstance();
    }

}
