package com.atguigu.oop;

public class Test2 {
    static int x, y, z;

    static {
        int x = 5;
        x--;
    }

    static {
        x--;
    }

    public static void main(String[] args) {
        System.out.println("x=" + x);
        z--;
        method();
        System.out.println("y=:" + (y));
        System.out.println("z=:" + (z));
        System.out.println("result:" + (z + y + ++z));
        System.out.println("y=:" + (y));
        System.out.println("z=:" + (z));
    }

    public static void method() {
        y = z++ + ++z;
    }
}

