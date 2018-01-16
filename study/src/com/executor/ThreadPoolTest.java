package com.executor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 线程池发送查询资产请求
 *
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

        List<Future<Map<String,Object>>> futures = executorService.invokeAll(workers,30,TimeUnit.SECONDS);
        executorService.shutdown();

        Integer all = 0;
        for (Future<Map<String,Object>> future : futures){
            if(future.isDone()){
                if((Integer) future.get().get("result") == 0){
                    all += (Integer) future.get().get("money");
                }else{
                    System.out.println(future.get().get("msg"));
                }
            }
        }
        System.out.println("你的总资产为： " + all);
    }

}
