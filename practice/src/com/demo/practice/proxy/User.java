package com.demo.practice.proxy;

/**
 * @ClassName: User
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/24 11:14
 * @Version: 1.0
 */
public class User implements Person {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(this.name + "交班费50元");
    }
}
