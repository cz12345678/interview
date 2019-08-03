package com.thunisoft.demo.error;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author chenzhen-1
 * @create 2019-06-08 14:40
 */
public class GCOverheadDemo {

    /**
     * 配置参数：
     *      -Xms5m -Xmx5m -XX:+PrintGCDetails
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     * @param args
     */
    public static void main(String[] args) {

        int count = 0;
        List<String> list = new ArrayList<>();
         try{
                while(true){
                    list.add(UUID.randomUUID().toString());
                    count++;
                }
         }
         catch (Throwable e){
             e.printStackTrace();
         }finally {
             System.out.println(count);
         }

    }

}
