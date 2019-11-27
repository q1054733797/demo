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
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentMapper.getStudents();
    }
}
