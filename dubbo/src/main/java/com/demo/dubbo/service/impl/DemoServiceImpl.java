package com.demo.dubbo.service.impl;

import com.demo.dubbo.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @ClassName: DemoServiceImpl
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/19 15:54
 * @Version: 1.0
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
    @Value("${server.port}")
    String port;

    @Override
    public String sayHello(String name) {
        return "hello " + name + ",i am from port " + port;

    }
}
