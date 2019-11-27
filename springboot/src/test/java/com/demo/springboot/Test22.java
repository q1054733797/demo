package com.demo.springboot;

import java.util.concurrent.*;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test22
 * @date : Create in 2019/10/4 20:32
 */
public class Test22 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> runnables = new ArrayBlockingQueue<>(5);
        ThreadPoolExecutor.DiscardOldestPolicy discardOldestPolicy = new ThreadPoolExecutor.DiscardOldestPolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, runnables, runnable -> new Thread(runnable, "测试线程"), discardOldestPolicy);
        executor.execute(() -> System.out.println(Thread.currentThread().getName() + "-->" + 123));
        executor.shutdown();
    }
}
