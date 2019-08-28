package com.demo.springboot.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Clazz
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/31 15:54
 * @Version: 1.0
 */
@Data
public class Clazz implements Serializable {
    private Integer clazzId;
    private String clazzName;
    private List<Teacher> teachers;
    private List<Student> students;
}
