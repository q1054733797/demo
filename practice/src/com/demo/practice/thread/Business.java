package com.demo.practice.thread;

/**
 * @ClassName: Business
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/4 15:19
 * @Version: 1.0
 */
public class Business {
    private boolean flag = true;

    public synchronized void mainMethod(){
        while (flag){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() +
                    "main thread running" + i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.flag = true;
        notify();
    }

    public synchronized void subMethod(){
        while (!flag){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() +
                    "sub thread running" + i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        this.flag = false;
        notify();
    }
}
