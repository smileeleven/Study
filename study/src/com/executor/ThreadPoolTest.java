package com.executor;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author aiboleepro
 * @date 2018-01-09 下午5:24
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

        for(int i=0;i<20;i++){
            final int num = i;
            executor.execute(() -> {
                System.out.println("正在执行task "+ num );
                try {
                    Thread.currentThread().sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("task "+ num +"执行完毕");
            });
            System.out.println("线程池中线程数目："+executor.getPoolSize()+
                               "，队列中等待执行的任务数目："+ executor.getQueue().size()+
                               "，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}
