package com.thunisoft.demo.error;

/**
 * @author chenzhen-1
 * @create 2019-06-08 15:06
 */
public class T {

    /**
     *
     * java.lang.IllegalThreadStateException
     *  if (threadStatus != 0)
     *       throw new IllegalThreadStateException();
     * @param args
     */
    public static void main(String[] args) {
        Thread t = new Thread();

        t.start();
        t.start();//  java.lang.IllegalThreadStateException

    }


}
