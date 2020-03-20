package com.thunisoft.test.listTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExample3 {

    // java.util.ConcurrentModificationException
    private static void test1(List<Integer> v1) { // foreach
        for(Integer i : v1) {
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // java.util.ConcurrentModificationException
    private static void test2(List<Integer> v1) { // iterator
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                v1.remove(i);
            }
        }
    }

    // success
    private static void test3(List<Integer> v1) { // for
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)) {
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        List<Integer> vector = new ArrayList<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        test2(vector);
    }
}

