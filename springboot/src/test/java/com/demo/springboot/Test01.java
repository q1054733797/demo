package com.demo.springboot;

import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.StudentService;
import com.demo.springboot.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: Test01
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/3 17:21
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test01 {
    @Autowired
    private TestService testService;

    @Autowired
    private StudentService studentService;

    @Test
    public void test01(){
//        Student student = new Student();
//        student.setName("张三");
//        student.setId(1);
//        student.setAge(25);
//        studentService.addStudent(student);
//        student.setId(2);
//        studentService.addStudent(student);
//        HashMap<String,String> map = new HashMap<>();
//        map.put("id", "1");
//        map.put("username", "admin");
//        map.put("password", "123456");
//        testService.addTest(map);
//        map.put("id", "2");
//        testService.addTest(map);
        List<Student> students = studentService.getStudents(null);
        System.out.println(students.size());
    }

}
