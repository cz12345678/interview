package com.thunisoft.test.concurrent.threadLocal;

import java.util.concurrent.TimeUnit;

public class InitValueinThreadLocal {


    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new AppendStringThread() .start();
        }
        TimeUnit.SECONDS.sleep(10L);
    }


    private static final StringBuilder INIT_VALUE = new StringBuilder("init");

    private static final ThreadLocal<StringBuilder> builder = new ThreadLocal<StringBuilder>() {
        @Override
        protected StringBuilder initialValue() {
            return INIT_VALUE;
        }
    };


    static class AppendStringThread extends Thread {
        @Override
        public void run() {
            StringBuilder inThread = builder.get();
            for (int i = 0; i < 10; i++) {
                inThread.append("-" + i);
            }
            System.out.println(inThread.toString());
        }
    }

}
