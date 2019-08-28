package com.demo.springboot;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.alibaba.fastjson.JSON;
import com.demo.springboot.mapper.ClazzMapper;
import com.demo.springboot.mapper.StudentMapper;
import com.demo.springboot.mapper.TeacherMapper;
import com.demo.springboot.pojo.Clazz;
import com.demo.springboot.pojo.Student;
import com.demo.springboot.pojo.Teacher;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootApplicationTests {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;

//    @Test //测试多对一
//    public void getStudent(){
//        List<Student> students = studentMapper.getStudents(new Student());
//        Clazz clazz = null;
//        for (Student student : students) {
//            System.out.println(student.getStudentName());
//            clazz = student.getClazz();
//            System.out.println(clazz.getClazzName());
//        }
//    }
//
//    @Test //测试一对多
//    public void getClazz(){
//        List<Clazz> clazzs = clazzMapper.getClazzs(new Clazz());
//        List<Student> students = null;
//        for (Clazz clazz : clazzs) {
//            System.out.println(clazz.getClazzName());
//            students = clazz.getStudents();
//            for (Student student : students) {
//                System.out.println(student.getStudentName());
//            }
//        }
//    }
//
//    @Test
//    public void addStudent(){
//        List<Student> students = new ArrayList<>();
//        Clazz clazz = new Clazz();
//        clazz.setClazzId(1);
//        Student student = new Student();
//        student.setStudentName("张三");
//        //student.setClazz(clazz);
//        students.add(student);
//        clazz = new Clazz();
//        clazz.setClazzId(2);
//        student = new Student();
//        student.setStudentName("李四");
//        //student.setClazz(clazz);
//        students.add(student);
//        clazz = new Clazz();
//        clazz.setClazzId(3);
//        student = new Student();
//        student.setStudentName("王五");
//        //student.setClazz(clazz);
//        students.add(student);
//        clazz = new Clazz();
//        clazz.setClazzId(4);
//        student = new Student();
//        student.setStudentName("赵六");
//        //student.setClazz(clazz);
//        students.add(student);
//        for (Student student1 : students) {
//            if(studentMapper.addStudent(student1) > 0){
//                log.info("添加成功");
//            }
//        }
//    }

    @Test
    public void addTeacher(){
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setTeacherName("张三");
        teachers.add(teacher);
        teacher = new Teacher();
        teacher.setTeacherName("李四");
        teachers.add(teacher);
        teacher = new Teacher();
        teacher.setTeacherName("王五");
        teachers.add(teacher);
        for (Teacher teacher1 : teachers) {
            if(teacherMapper.addTeacher(teacher1) > 0){
                log.info("添加成功");
            }
        }
    }

    @Test
    public void addClazz(){
        Clazz clazz = new Clazz();
        clazz.setClazzName("大二");
        List<Clazz> clazzes = new ArrayList<>();
        clazzes.add(clazz);
        clazz.setClazzName("大三");
        clazzes.add(clazz);
        clazz.setClazzName("大四");
        clazzes.add(clazz);
        for (Clazz clazz1 : clazzes) {
            if(clazzMapper.addClazz(clazz1) > 0){
                log.info("添加成功");
            }
        }
    }
}
