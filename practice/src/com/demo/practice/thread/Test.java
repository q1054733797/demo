package com.demo.practice.thread;

/**
 * @ClassName: Test
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/4 15:05
 * @Version: 1.0
 */
public class Test implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("多线程输出" + i);
        }
    }
}
