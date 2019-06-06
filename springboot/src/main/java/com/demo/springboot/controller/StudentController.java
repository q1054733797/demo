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
    public List getStudents(Student student){
        Page<Object> page = PageHelper.startPage(2, 2,true);
        List<Student> students = studentService.getStudents(student);
        System.out.println(students);
        System.out.println("总页数：" + page.getPages());
        System.out.println("总数据条数:" + page.getTotal());
        Page<Object> page1 = PageHelper.offsetPage(2, 2);
        students = studentService.getStudents(student);
        System.out.println(students);
        System.out.println("总页数：" + page1.getPages());
        System.out.println("总数据条数:" + page1.getTotal());
        return students;
    }
}
