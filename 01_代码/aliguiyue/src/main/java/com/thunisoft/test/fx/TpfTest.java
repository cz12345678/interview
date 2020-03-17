package com.thunisoft.test.fx;

import java.util.ArrayList;
import java.util.List;

public class TpfTest {

    public static void main(String[] args) {

        List<Animals> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Garfield> garfields = new ArrayList<>();


        animals.add(new Animals());
        cats.add(new Cat());
        garfields.add(new Garfield());

        // 编译出错，只能赋值 Cat 及其 Cat 子类的集合
//        List<? extends Cat> cats0 = animals;
        List<? extends Cat> cats1 = garfields;
        List<? extends Cat> cats2 = cats;

        // 由 extends 修饰的集合泛型不能执行add/set操作,
//        cats1.add(new Cat());
        cats1.get(0);
        cats1.remove(0);
        cats1.clear();
//        cats1.set(0,new Cat());

        // 编译出错，只能赋值 Cat 及其 Cat 父类的集合
//        List<? super Cat> cats5 = garfields;
        List<? super Cat> cats3 = cats;
        List<? super Cat> cats4 = animals;


        // 由 super 修饰的集合泛型可执行集合的所有操作，但是在获取的时候，失去了泛型
        cats3.add(new Cat());
        cats3.remove(0);
        cats3.set(0,new Cat());
        cats3.clear();
        Object object = cats3.get(0);


    }

}

class Animals{}

class Cat extends Animals{}

class Garfield extends Cat{}
