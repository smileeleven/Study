package net.i2finance.socketAD;

import java.util.concurrent.*;  

/** 
 * 任务执行者 
 *  
 * @author laobai
 * @since 1.0.0 <p>2015-6-8 上午10:33:09</p> 
 */  
public class ThreadPoolTaskExecutor {  
  
    private ThreadPoolTaskExecutor() {  
  
    }  
  
    private static ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {  
        int count;  
  
        /* 执行器会在需要自行任务而线程池中没有线程的时候来调用该程序。对于callable类型的调用通过封装以后转化为runnable */  
        public Thread newThread(Runnable r) {  
            count++;  
            Thread invokeThread = new Thread(r);  
            invokeThread.setName("Courser Thread-" + count);  
            invokeThread.setDaemon(false);// //????????????  
  
            return invokeThread;  
        }  
    });  
  
    public static void invoke(Runnable task, TimeUnit unit, long timeout) throws TimeoutException, RuntimeException {  
        invoke(task, null, unit, timeout);  
    }  
  
    public static <T> T invoke(Runnable task, T result, TimeUnit unit, long timeout) throws TimeoutException,  
            RuntimeException {  
        Future<T> future = executor.submit(task, result);  
        T t = null;  
        try {  
            t = future.get(timeout, unit);  
        } catch (TimeoutException e) {  
            throw new TimeoutException("Thread invoke timeout ...");  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
        return t;  
    }  
  
    public static <T> T invoke(Callable<T> task, TimeUnit unit, long timeout) throws TimeoutException, RuntimeException {  
        // 这里将任务提交给执行器，任务已经启动，这里是异步的。  
        Future<T> future = executor.submit(task);  
        // System.out.println("Task aready in thread");  
        T t = null;  
        try {  
            /* 
             * 这里的操作是确认任务是否已经完成，有了这个操作以后  
             * 1)对invoke()的调用线程变成了等待任务完成状态 
             * 2)主线程可以接收子线程的处理结果 
             */  
            t = future.get(timeout, unit);  
        } catch (TimeoutException e) {  
            throw new TimeoutException("Thread invoke timeout ...");  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
  
        return t;  
    }  
}  
