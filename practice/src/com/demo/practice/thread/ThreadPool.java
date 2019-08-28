package com.demo.practice.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPool
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/26 10:30
 * @Version: 1.0
 */
public class ThreadPool {
    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, 4, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),new ThreadPoolExecutor.AbortPolicy());
        try {
            for(int i=0;i<7;i++){
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        }catch (Exception e){
            System.out.println(e);
            threadPoolExecutor.shutdown();
        }
        threadPoolExecutor.shutdown();
    }
}
