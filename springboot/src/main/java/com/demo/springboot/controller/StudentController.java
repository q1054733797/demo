package com.demo.springboot.controller;

import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.StudentService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: StudentController
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:56
 * @Version: 1.0
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudents")
    @ResponseBody
    public Page<Object> getStudents(Student student,Integer pageNum,Integer pageSize){
        System.out.println(pageNum);
        System.out.println(pageSize);
        Page<Object> page = PageHelper.startPage(pageNum, pageSize,true);
        page.setReasonable(true);
        List<Student> students = studentService.getStudents(student);
        System.out.println(page.getPageNum());
        System.out.println(students);
        System.out.println("总页数：" + page.getPages());
        System.out.println("总数据条数:" + page.getTotal());
        return page;
    }
}
