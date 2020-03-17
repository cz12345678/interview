package com.thunisoft.test.staticCode;

/**
 * 静态代码块 与 静态方法 之间无先后顺序
 * 静态属性 与 静态方法 间无先后顺序
 * 静态属性间有相互顺序
 * 静态方法间无相互顺序
 *
 */
public class StaticCodeTest {



    static String prior = "done";

    static String last = f() ? g() : prior;


    public static boolean f(){
        g();
        return true;
    }


    public static String g(){
        return "hello world";
    }

    static {
        System.out.println(last);
        g();
    }

}
