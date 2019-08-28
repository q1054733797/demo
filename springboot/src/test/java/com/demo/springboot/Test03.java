package com.demo.springboot;

import com.demo.springboot.pojo.Student;
import com.demo.springboot.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName: Test03
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/1 16:01
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test03 {
    @Autowired
    private ProcedureService procedureService;

    @Test
    public void test(){
        System.out.println(procedureService.sendMessage("demo", "tag-a", "what the fuck"));
    }

}
