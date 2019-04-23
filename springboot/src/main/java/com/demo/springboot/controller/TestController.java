package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/23 11:07
 * @Version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test(){
        return "login";
    }

    @RequestMapping("test02")
    @ResponseBody
    public String test2(){
        return "hello world";
    }
}
