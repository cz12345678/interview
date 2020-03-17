package com.thunisoft.test.listTest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在遍历中删除
 */
public class IteratorLockTest {

    public static void main(String[] args) {


//        List<String> list = new CopyOnWriteArrayList<String>();
        List<String> list = new ArrayList<>();

        for (int i = 1; i <=30; i++)
        {
            new Thread(() -> {
//                synchronized (list){
                    list.add(UUID.randomUUID().toString().substring(0,4));//320x
                    System.out.println(list);
//                }
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException 	写时复制

    }

}


