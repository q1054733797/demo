package com.demo.springboot;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test21
 * @date : Create in 2019/10/4 10:31
 */
public class Test21 {
    private int temp = 1;

    public void print(){
        System.out.println(Thread.currentThread().getName() + "-->" + temp);
        temp++;
    }
}
