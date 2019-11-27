package com.demo.springboot;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test19
 * @date : Create in 2019/10/3 15:50
 */
public class Test20 {
    private static boolean isOk = false;

    public static void main(String[] args) {
        Test21 test21 = new Test21();
        new Thread(() -> {
            for(int i=0;i<10;i++){
                synchronized (test21){
                    if(!isOk){
                        try {
                            test21.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    test21.print();
                    isOk = false;
                    test21.notify();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i=0;i<10;i++){
                synchronized (test21){
                    if(isOk){
                        try {
                            test21.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    test21.print();
                    isOk = true;
                    test21.notify();
                }
            }
        }).start();
    }
}
