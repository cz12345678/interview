package com.thunisoft.demo;

import com.thunisoft.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author chenzhen-1
 * @create 2019-06-01 17:11
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception{

//        closeDoor();
        // 枚举使用
        countryDown();

    }

    private static void countryDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getName()).start();

        }
        countDownLatch.await();
        System.out.println( Thread.currentThread().getName() + "\t **********秦帝国，一统华夏");
    }

    // 班长锁门case
    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {

             new Thread(() -> {
                 System.out.println(Thread.currentThread().getName() + "\t 离开教室");
                 countDownLatch.countDown();
             },String.valueOf(i)).start();

        }
        countDownLatch.await();
        System.out.println( Thread.currentThread().getName() + "\t 班长锁门");
    }


}
