package com.executor;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author aiboleepro
 * @date 2018-01-09 下午5:24
 **/
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        WorkerBank1 workerBank1 = new WorkerBank1();
        WorkerBank2 workerBank2 = new WorkerBank2();
        WorkerBank3 workerBank3 = new WorkerBank3();
        List<Worker> workers = new LinkedList<>();
        workers.add(workerBank1);
        workers.add(workerBank2);
        workers.add(workerBank3);
        List<Future<Integer>> futures =  executorService.invokeAll(workers,30,TimeUnit.SECONDS);
        executorService.shutdown();

        Integer all = 0;
        for (Future<Integer> future : futures){
            all += future.get();
        }

        System.out.println("你的总资产为： " + all);
    }
}
