package com.thunisoft.demo.ref;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author chenzhen-1
 * @create 2019-06-08 11:39
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {

//        myHashMap();

        WeakHashMap<Integer,String> map = new WeakHashMap<>();

        Integer key = new Integer(2);// 传入的key不可以是不变的，必须是new出来的
        String value = "WeakHashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.out.println(map + "\t" + map.size());


    }

    private static void myHashMap() {
        HashMap<String,Object> map = new HashMap<>();

        String key = "xx";
        String value = "HashMap";

        map.put(key,value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }

}
