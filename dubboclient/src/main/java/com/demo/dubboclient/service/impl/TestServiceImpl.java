package com.demo.dubboclient.service.impl;

import com.demo.dubbo.service.DemoService;
import com.demo.dubboclient.service.TestService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TestServiceImpl
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/19 16:07
 * @Version: 1.0
 */
@Service
public class TestServiceImpl implements TestService {
    //@Reference(version = "1.0")
    private DemoService demoService;

    @Override
    public String test(String name) {
        return demoService.sayHello(name);
    }
}
