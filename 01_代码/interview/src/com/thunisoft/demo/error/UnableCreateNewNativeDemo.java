package com.thunisoft.demo.error;

import java.util.concurrent.TimeUnit;

/**
 * @author chenzhen-1
 * @create 2019-06-08 15:11
 */
public class UnableCreateNewNativeDemo {

    /**
     *      java.lang.OutOfMemoryError: unable to create new native thread
     * @param args
     */
    public static void main(String[] args) {

        for (int i = 0;; i++) {

            System.out.println("***************************i :\t" + i);

             new Thread(() -> {
                 try{ TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch(InterruptedException e){ e.printStackTrace();}
             },String.valueOf(i)).start();



//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try{ TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);} catch(InterruptedException e){ e.printStackTrace();}
//                }
//            },String.valueOf(i)).start();

        }



    }

}
