package com.demo.springboot.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Teacher
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/31 15:54
 * @Version: 1.0
 */
@Data
public class Teacher implements Serializable {
    private Integer teacherId;
    private String teacherName;
    private List<Student> students;
    private List<Clazz> clazzes;
}
