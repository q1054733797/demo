package com.demo.springdata;

import com.demo.springdata.pojo.User;
import com.demo.springdata.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void getUsers() {
        List<User> users = userService.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        String password = DigestUtils.md5DigestAsHex("admin123456".getBytes());
        User user = new User("张三", "zhangsan", password);
        user = userService.addUser(user);
        System.out.println(user);
    }

    @Test
    public void deleteUser() {
        User user = userService.getUserById(3);
        if(user != null){
            userService.deleteUser(user);
        }
    }

    @Test
    public void updateUser() {
        User user = userService.getUserById(3);
        if(user != null){
            user.setUsername("张三");
            user = userService.updateUser(user);
        }
        System.out.println(user);
    }

}
