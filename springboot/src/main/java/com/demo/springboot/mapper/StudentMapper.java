package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName: StudentMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:52
 * @Version: 1.0
 */
@Mapper
@Repository
public interface StudentMapper {
    @Update("update t_student set clazzId = #{clazzId} where studentId = #{studentId}")
    int updateStudent(Student student);

    @Select("select * from t_student")
    List<Student> getStudents();
}
