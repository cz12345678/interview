package com.thunisoft.demo;

/**
 * @author chenzhen-1
 * @create 2019-05-31 9:22
 *
 * 单例模式 = DCL（双端检索机制） + volatile（禁止指令重排）
 *
 */
public class SingletonDemo {

//    private static SingletonDemo instance = null;
    //禁止指令重排
    private static volatile SingletonDemo instance = null;

    private SingletonDemo() {
        System.out.println("SingletonDemo is construct");
    }


    //双端检索机制（DCL）
    public static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }






    //同步方法
//    public static SingletonDemo getInstance(){
//    public static synchronized SingletonDemo getInstance(){
//
//        if(instance == null){
//
//            instance = new SingletonDemo();
//        }
//        return instance;
//    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
             new Thread(() -> {
                 SingletonDemo.getInstance();
             },String.valueOf(i)).start();
        }
    }

}
