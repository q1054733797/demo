package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: StudentMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:52
 * @Version: 1.0
 */
@Mapper
public interface StudentMapper {
    List<Student> getStudents(Student student);
    int addStudent(Student student);
}
