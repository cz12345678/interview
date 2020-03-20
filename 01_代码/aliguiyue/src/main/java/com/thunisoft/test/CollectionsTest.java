package com.thunisoft.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        List<List<String>> lists = Collections.singletonList(list);
        List<List<String>> lists2 = Collections.singletonList(list);


        Collections.emptyList();

    }


}
