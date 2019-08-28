package com.demo.practice.proxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName: TestProxy
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/4 15:52
 * @Version: 1.0
 */
public class TestProxy {
    public static void main(String[] args) {
        User user = new User("张三");
        Person userProxy = (Person)Proxy.newProxyInstance(User.class.getClassLoader(),
                User.class.getInterfaces(),
                (proxy,method,argz) -> method.invoke(user,argz));
        userProxy.giveMoney();
    }
}
