package com.demo.springsecurity.controller;

import com.demo.springsecurity.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/28 10:54
 * @Version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
