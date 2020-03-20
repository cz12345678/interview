package com.thunisoft.test.concurrent.futures;


import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ListenableFutureTest {


    public static void main(String[] args) {

        System.out.println("-------------------main....starter------------------------------------");

        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

       try{
           final ListenableFuture<Integer> listenableFuture = executorService.submit(new Callable<Integer>() {
               @Override
               public Integer call() throws Exception {
                   System.out.println("call execute..");
                   TimeUnit.SECONDS.sleep(1);

                   int error = 7 / 0;
                   return 7;
               }
           });

           Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
               @Override
               public void onSuccess(Integer result) {
                   System.out.println("get listenable future's result with callback " + result);
               }

               @Override
               public void onFailure(Throwable t) {
                   System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

//                   t.printStackTrace();
               }
           });
       }finally{
           executorService.shutdown();
       }




        System.out.println("-------------------main....end------------------------------------");


    }
}
