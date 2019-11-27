package com.demo.springboot;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test19
 * @date : Create in 2019/10/3 15:50
 */
public class Test19 {
    private static int temp = 1;
    private static boolean isOk = false;

    public static void main(String[] args) {
        new Thread(() -> {
            while (temp < 10){
                if(isOk){
                    System.out.println(Thread.currentThread().getName() + "-->" + temp);
                    temp++;
                    isOk = !isOk;
                }
            }
        }).start();

        new Thread(() -> {
            while (temp < 10){
                if(!isOk){
                    System.out.println(Thread.currentThread().getName() + "-->" + temp);
                    temp++;
                    isOk = !isOk;
                }
            }
        }).start();
    }
}
