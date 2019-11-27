package com.demo.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.enmu.TestEnum;
import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.pojo.EasyUIDatagridResult;
import com.demo.springboot.pojo.Student;
import com.demo.springboot.pojo.User;
import com.demo.springboot.service.StudentService;
import com.demo.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/23 11:07
 * @Version: 1.0
 */
@Controller
@Api(tags = "测试类")
@CrossOrigin
@Slf4j
public class TestController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudents")
    @ResponseBody
    public List<Student> getStudents(){
        List<Student> students = studentService.getStudents();
        new Thread(() -> {
            int i = 0;
            for (Student student : students) {
                student.setClazzId(student.getClazzId() + 1);
                System.out.println("执行" + i + "次");
                studentService.updateStudent(student);
                i++;
            }
        }).start();
        return students;
    }

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
    @ResponseBody
    public String test03(@RequestBody Student student, @RequestHeader HashMap<String,String> headers, HttpServletResponse response){
        for (String s : headers.keySet()) {
            System.out.println(headers.get(s));
        }
        headers.forEach((key,value) ->
                System.out.println(key + ":" + value)
        );
        return "hello " + student.getStudentId() + student.getStudentName();
    }

    @RequestMapping("test04")
    @ResponseBody
    public String test04(){
        TestEnum.SUCCESS.setDesc("213");
        return TestEnum.SUCCESS.getDesc();
    }

    @RequestMapping("test05")
    @ResponseBody
    public String test05(){
        return TestEnum.SUCCESS.getDesc();
    }
}
