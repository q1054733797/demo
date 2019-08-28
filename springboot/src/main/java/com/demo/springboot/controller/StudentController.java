package com.demo.springboot.controller;

import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: StudentController
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:56
 * @Version: 1.0
 */
@Controller
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("getStudents")
    @ResponseBody
    public PageInfo getStudents(Student student,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum, pageSize,true)
                    .setReasonable(true);
        List<Student> students = studentService.getStudents(student);
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }
}
