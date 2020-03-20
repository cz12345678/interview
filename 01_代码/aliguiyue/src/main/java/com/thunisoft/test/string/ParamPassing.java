package com.thunisoft.test.string;

public class ParamPassing {

    private static int intStatic = 222;

    private static String stringStatic = "old string";

    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");


    public static void main(String[] args) {

//        method(stringBuilderStatic, stringBuilderStatic );
//
//        System.out.println(stringBuilderStatic);

        method(stringStatic);
        System.out.println(stringStatic);

    }

    // A方法
    public static void method(int intStatic) {
        intStatic = 777;
    }

    // B
    public static void method() {
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        stringStatic = "new string";
    }

    public static void method(StringBuilder stringBuilderStaticl , StringBuilder stringBuilderStatic2) {

        stringBuilderStaticl.append(".method.first-");
        stringBuilderStatic2.append (".method.second-");

        stringBuilderStaticl = new StringBuilder("new StringBuilder");

        stringBuilderStaticl.append("new method's append");
    }






}
