package com.demo.springboot;

import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test18
 * @date : Create in 2019/10/2 14:55
 */
@SpringBootTest(classes = SpringbootApplication.class)
@RunWith(SpringRunner.class)
public class Test18 {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
//        List<User> users = userMapper.getUsers(new User());
//        System.out.println(users);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(123);
            List<User> users = userMapper.getUsers(new User());
            System.out.println(users);
            System.out.println(456);
        }).start();
    }
}
