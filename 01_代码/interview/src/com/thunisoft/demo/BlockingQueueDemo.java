package com.thunisoft.demo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author chenzhen-1
 * @create 2019-06-02 10:38
 *
 *
 *
 *
 *  1. 队列
 *
 *  2. 阻塞队列
 *      2.1 阻塞队列有没有好的一面
 *
 *      2.2 不得不阻塞，你如何管理
 *
 *
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws Exception {

//        List<String> list = null;

        // add 和 remove演示
//        addAndRemoveEx();

        //offer 和 poll 演示
//        offerAndPoll();

        //put 和 take 演示
//        putAndTake();

        timeOut();


    }

    /**
     * 过时不候
     * 队列已满时再次插入数据：若一定时间内不能插入，则直接返回false
     * 队列已空时再次获取数据：若一定时间内不能获取，直接返回null
     * @throws InterruptedException
     */
    private static void timeOut() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        System.out.println(blockingQueue.offer("a",2, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b",2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c",2,TimeUnit.SECONDS));
//        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS));
    }

    /**
     * 当队列已满时，再次添加数据时，线程会一直阻塞，直到添加为止
     * 获取同理，当队列空时，线程会阻塞，直到获取到元素为止
     * @throws InterruptedException
     */
    private static void putAndTake() throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        System.out.println("xxxxxxxxxxxxxxxxxx");
//        blockingQueue.put("d");

        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
        blockingQueue.take();
    }

    /**
     * offer 添加，添加成功返回true，添加失败返回false
     * poll  获取，返回元素或null
     * peek  返回队头元素，为空返回null
     */
    private static void offerAndPoll() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
//        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        System.out.println(blockingQueue.peek());// 获取队列头的元素，空的话返回null
    }

    /**
     * 队列已满，插入失败直接报异常，获取、element() 方法同理，
     */
    private static void addAndRemoveEx() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);


        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

//        System.out.println(blockingQueue.add("d"));

//        System.out.println(blockingQueue.element());// 返回队列首个元素,如果为空抛出异常

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println("xxxxxxxxxxxxxxx");
//        System.out.println(blockingQueue.element());
        System.out.println("xxxxxxxxxxxxxxx");
//        System.out.println(blockingQueue.remove());

    }

}
