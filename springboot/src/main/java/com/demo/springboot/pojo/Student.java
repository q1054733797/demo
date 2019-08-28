package com.demo.springboot.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: Student
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:50
 * @Version: 1.0
 */
@ApiModel(value = "Student",description = "学生类")
//@Setter
//@Getter
@Data
public class Student implements Serializable {
    private Integer studentId;
    private String studentName;
    private List<Teacher> teachers;
    private Clazz clazz;
}
