package com.example.admin.imageloader.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能：
 * 描述：
 * Created by chenjie on 2017/9/20.
 */

public class ThreadPoolText {


    public static class ThreadPoolTest {
        public static void main(String[] args) throws InterruptedException {
            ExecutorService threadPool = Executors.newCachedThreadPool();//线程池里面的线程数会动态变化，并可在线程线被移除前重用
            for (int i = 1; i <= 3; i ++) {
                final  int task = i;   //10个任务
                TimeUnit.SECONDS.sleep(1);
                threadPool.execute(new Runnable() {    //接受一个Runnable实例
                    public void run() {
                        System.out.println("线程名字： " + Thread.currentThread().getName() +  "  任务名为： "+task);
                    }
                });
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new Callable<String>() {   //接受一上callable实例
            public String call() throws Exception {
                return "MOBIN";
            }
        });
        System.out.println("任务的执行结果："+future.get());
    }

}
