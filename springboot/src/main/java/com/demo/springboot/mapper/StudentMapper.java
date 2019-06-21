package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: StudentMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:52
 * @Version: 1.0
 */
public interface StudentMapper {
    @Select("select * from t_student order by id asc")
    List<Student> getStudents(Student student);
}
