package com.thunisoft.demo;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{

    // 生产Flag，true则生产，false则不生产
    private volatile boolean FLAG = true;

    // 记录个数
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    /**
     * 有参构造器，应该传接口，不要传实现类
     * @param blockingQueue
     */
    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产者：只要FLAG为true，每秒生产一次
     * @throws Exception
     */
    public void produce() throws  Exception{

        String data = null;
        boolean retValue;
        while(FLAG){
            data = atomicInteger.incrementAndGet() + "";
            // 添加
            retValue = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if(retValue){
                System.out.println(Thread.currentThread().getName() + "\t *****************插入队列" + data + "成功");
            }else{
                System.out.println(Thread.currentThread().getName() + "\t *****************插入队列" + data + "失败");
            }

            // 每1秒钟执行一次
            try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){ e.printStackTrace();}
        }
        System.out.println(Thread.currentThread().getName() + "\t 大老板叫停，FLAG=false，生产动作结束！");
    }

    /**
     * 消费者
     * @throws Exception
     */
    public void consumer()throws  Exception{

        String result = null;
        while(true){
            // 从队列中取数据，时间为2秒
            result = blockingQueue.poll(2,TimeUnit.SECONDS);
            if (null == result || result.equalsIgnoreCase("")){
                FLAG = false;

                System.out.println(Thread.currentThread().getName() + "\t 超过2秒没有取到蛋糕，消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列" + result + "成功");
        }

//        System.out.println("消费者感知到FLAG=false，停止消费！");
    }

    public void stop(){
        this.FLAG = false;
    }


}
/**
 * @author chenzhen-1
 * @create 2019-06-02 14:30
 *
 * volatile/CAS/AtomicInteger/BlockeQueue/线程交互/原子引用
 *
 *
 * 生产者：
 *      只要是true就生产，false就停止生产
 * 消费者：
 *      两秒钟取一次，若取不到则消费者退出。
 *
 */
public class ProdConsumer_BlockQueueDemo {

    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

         new Thread(() -> {
             System.out.println(Thread.currentThread().getName() + "\t生产者线程启动");
             try {
                 myResource.produce();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"prod").start();

         new Thread(() -> {
             System.out.println(Thread.currentThread().getName() + "\t消费者线程启动");
             try {
                 myResource.consumer();
             } catch (Exception e) {
                 e.printStackTrace();
             }
         },"cons").start();

         try{ TimeUnit.SECONDS.sleep(10);} catch(InterruptedException e){ e.printStackTrace();}
         System.out.println("时间到，停止生产");
         myResource.stop();
    }

}
