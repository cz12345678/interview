package com.thunisoft.demo.error;

import java.nio.ByteBuffer;

/**
 * @author chenzhen-1
 * @create 2019-06-08 14:56
 */
public class DirectBufferMemoryDemo {

    /**
     * 配置参数：
     *  -Xms5m -Xmx5m -XX:MaxDirectMemorySize=5m
     * 异常：
     *      java.lang.OutOfMemoryError: Direct buffer memory
     * @param args
     */
    public static void main(String[] args) {
//        directMemory();
        ByteBuffer.allocateDirect(6 * 1024 * 1024);

    }

    private static void directMemory() {
        System.out.println("配置的直接内存：" + "\t"  + (double)(sun.misc.VM.maxDirectMemory() / 1024 /1024) + "MB");
    }
}

