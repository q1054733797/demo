package com.demo.springboot;

import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test01
 * @date : Create in 2019/9/24 20:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test01 {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        User user = new User();
        user.setUsername("12345555");
        List<User> user2 = userMapper.getUsers(user);
        System.out.println(user2 == null);
    }
}
