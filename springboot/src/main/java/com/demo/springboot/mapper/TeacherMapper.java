package com.demo.springboot.mapper;

import com.demo.springboot.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: TeacherMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/31 15:50
 * @Version: 1.0
 */
@Mapper
public interface TeacherMapper {
    int addTeacher(Teacher teacher);
}
