package com.demo.springboot.service;

import com.demo.springboot.pojo.Student;

import java.util.List;

/**
 * @ClassName: StudentService
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:54
 * @Version: 1.0
 */
public interface StudentService {
    List<Student> getStudents(Student student);
    int addStudent(Student student);
}
