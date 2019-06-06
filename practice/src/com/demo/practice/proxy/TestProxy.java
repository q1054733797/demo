package com.demo.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestProxy
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/4 15:52
 * @Version: 1.0
 */
public class TestProxy {
    final List<String> list = new ArrayList<>();

    public void testProxy(){
        List<String> list1 = new ArrayList<>();
        Object proxyInstance = Proxy.newProxyInstance(list.getClass().getClassLoader(),
                list.getClass().getInterfaces(),
                (proxy,method,args) -> method.invoke(list, args));
        if(proxyInstance instanceof List){
            list1 = (List<String>)proxyInstance;
        }
        list1.add("what the hell");
        System.out.println(proxyInstance);
    }

    public static void main(String[] args) {
        TestProxy testProxy = new TestProxy();
        testProxy.testProxy();
    }
}
