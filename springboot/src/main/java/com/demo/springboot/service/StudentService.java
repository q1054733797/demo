package com.demo.springboot.service;

import com.demo.springboot.pojo.Student;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @ClassName: StudentService
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:54
 * @Version: 1.0
 */
public interface StudentService {
    int updateStudent(Student student);

    List<Student> getStudents();
}
