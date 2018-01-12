package com.i2f.teach.socket;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author ChenWei 2018-01-11 17:41
 **/
public class Client {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();
    WorkerA a=new WorkerA();
    WorkerA b=new WorkerA();
    List<Worker> list=new ArrayList<>();
    list.add(a);
    list.add(b);
    List<Future<Map>> futures = executorService.invokeAll(list, 30, TimeUnit.SECONDS);
    //遍历结果
    for (Future future:futures
    ) {
      System.out.println(future.toString());
    }
  }
}
