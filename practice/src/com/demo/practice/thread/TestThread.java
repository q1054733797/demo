package com.demo.practice.thread;

/**
 * @ClassName: TestThread
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/4 14:56
 * @Version: 1.0
 */
public class TestThread{
    public static void main(String[] args) {
        final Business business = new Business();
        new Thread(() -> {
            for (int i=0;i<3;i++){
                business.subMethod();
            }
        }).start();
        for (int i=0;i<3;i++){
            business.mainMethod();
        }
    }
}
