package com.demo.dubboclient.controller;

import com.demo.dubboclient.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/19 16:09
 * @Version: 1.0
 */
@Controller
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping("test")
    @ResponseBody
    public String test(String name){
        try {
            return testService.test(name);
        }catch (Exception e){
            return "可能dubbo妈没了";
        }

    }
}
