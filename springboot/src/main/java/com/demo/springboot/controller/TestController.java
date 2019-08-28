package com.demo.springboot.controller;

import com.demo.springboot.pojo.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/23 11:07
 * @Version: 1.0
 */
@Controller
@Api(tags = "测试类")
@CrossOrigin
public class TestController {
    @RequestMapping("test")
    @ApiOperation("测试方法")
    public String test(Model model,Student student){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "login";
    }

    @RequestMapping("test02")
    @ResponseBody
    public String test2(@RequestBody Student student, @RequestHeader HashMap<String,String> headers, HttpServletResponse response){
        for (String s : headers.keySet()) {
            System.out.println(headers.get(s));
        }
        headers.forEach((key,value) ->
            System.out.println(key + ":" + value)
        );
        //return "hello " + student.getStudentId() + student.getStudentName();
        return null;
    }

    @RequestMapping("test03")
    public String test3(){
        return "test";
    }

    @RequestMapping("test04")
    @ResponseBody
    public String test4(){
        return "test04";
    }
}
