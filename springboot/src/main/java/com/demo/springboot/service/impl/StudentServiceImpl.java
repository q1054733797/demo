package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: StudentServiceImpl
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:54
 * @Version: 1.0
 */
@Transactional
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudents(Student student) {
        return studentMapper.getStudents(student);
    }
}
