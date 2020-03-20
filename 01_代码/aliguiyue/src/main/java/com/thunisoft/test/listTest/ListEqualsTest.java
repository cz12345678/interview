package com.thunisoft.test.listTest;

import java.util.*;

public class ListEqualsTest {

    public static void main(String[] args) {

//        listTest();

//        setTest();

        mapTest();

    }

    private static void mapTest() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(1, 1);

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(1, 1);

        System.out.println(hashMap.equals(treeMap));// true
    }

    private static void setTest() {
        HashSet<Integer> hashSet = new HashSet<>();

        hashSet.add(1);

        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(1);

        System.out.println(hashSet.equals(treeSet)); // true
    }

    private static void listTest() {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);

        System.out.println(arrayList.equals(linkedList)); //true
    }

}
