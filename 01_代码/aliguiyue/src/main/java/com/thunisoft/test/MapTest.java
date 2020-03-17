package com.thunisoft.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

        Map<String,Object> map = new HashMap<String,Object>();


        Set<String> strings = map.keySet();

        strings.add("xxxxxx");

    }

}
