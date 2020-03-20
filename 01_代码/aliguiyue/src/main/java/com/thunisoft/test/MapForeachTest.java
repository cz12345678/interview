package com.thunisoft.test;

import java.util.HashMap;
import java.util.Map;

public class MapForeachTest {


    public static void main(String[] args) {

        Map<String,Object> map = new HashMap();

        map.put("xx",1);
        map.put("yy",2);
        map.put("zz",3);
        map.put("ww",4);

        map.forEach((key, value) -> {
            System.out.println(key + "\t" + value);
        });



    }

}
