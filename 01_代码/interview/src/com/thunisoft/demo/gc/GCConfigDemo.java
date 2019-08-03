package com.thunisoft.demo.gc;

import java.util.UUID;

/**
 * @author chenzhen-1
 * @create 2019-06-09 11:45
 */
public class GCConfigDemo {

    /**'
     *
     * 1. 使用SerialGC，默认激活老年代的SerialGC
     *    参数配置：
     *          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
     * 2. 使用ParaNewGC, 默认激活老年代的串行GC，但是系统提示已经是过时的使用方法
     *          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC
     *         备注情况：Java HotSpot(TM) 64-Bit Server VM warning: Using the ParNew young collector with the
     *          Serial old collector is deprecated and will likely be removed in a future release
     * 3. 使用ParallelGC，默认激活老年代的并行GC
     *          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC
     *       ***** 默认是使用并行GC，不添加也可
     *        -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
     * 4. 使用CMS垃圾回收器，激活ParaNewGC和老年代SerialGC（作为后备方案）
     *          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
     *
     * 5. 使用G1垃圾收集器, G1 收集器不分新生代和老年代，只有堆内存和元空间
     *          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
     *
     *
     *
     *
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "qwe";
        try{
            while (true){
                str += str + UUID.randomUUID().toString();
            }
        }catch(Throwable e){
            e.printStackTrace();
        }


    }

}
