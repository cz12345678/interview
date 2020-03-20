package com.thunisoft.test.f1;

import com.thunisoft.test.f2.Son;

/**
 * 方法的权限控制符
 *  子类 覆写 父类的方法，方法上必须添加注解@Override
 */
public class Father {

    void method(){
        System.out.println("I'm Father");
    }
}

class Main{

    public static void main(String[] args) {

        Father father = new Son();

        father.method();

    }
}














//I'm Father