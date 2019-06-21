package com.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/23 11:07
 * @Version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("test")
    public String test(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "login";
    }

    @RequestMapping("test02")
    @ResponseBody
    public String test2(){
        return "hello world";
    }
}
