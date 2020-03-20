package com.thunisoft.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FxTest {

    public static void main(String[] args) {
        addTest();

//        getTest();

//        abTest();


    }

    /**
     * a b 测试
     */
    private static void abTest() {
        List<? super A> list = new ArrayList<>();

        list.add(new B());

        list.add(new A());

        Object object = list.get(1);



    }

    /**
     * 泛型通配符 super： get方法的返回值都是Object
     */
    private static void getTest() {
        List<? super Number> list = new ArrayList<>();

        list.add(25);
        list.set(0,100);
        list.add(200f);
        list.add(20.25);

        list.add(6L);




        System.out.println(list.get(1));
    }

    /**
     * 泛型通配符： extends
     *      只读集合
     *
     *
     */
    private static void addTest() {
        List<? extends Number> list = new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) ;

//        list.add(3);
//
//        list.set(0,5);

        Integer number = (Integer)list.get(2);

        Number number1 = list.get(1);



        System.out.println(number);
    }

}

class A {}

class B extends A{}


