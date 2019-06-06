package com.demo.springdata.controller;

import com.demo.springdata.pojo.User;
import com.demo.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName: UserController
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/6 14:49
 * @Version: 1.0
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUsers")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
