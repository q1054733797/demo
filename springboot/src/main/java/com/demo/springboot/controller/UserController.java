package com.demo.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.pojo.EasyUIDatagridResult;
import com.demo.springboot.pojo.User;
import com.demo.springboot.service.UserService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: UserController
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/14 14:46
 * @Version: 1.0
 */
@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("getUsers")
    public EasyUIDatagridResult getUsers(String page, String rows, User user,String username){
        log.info("user-->" + JSON.toJSONString(user));
        log.info(username);
        EasyUIDatagridResult result = userService.getUsers(page, rows, user);
        return result;
    }

    @PostMapping("addUser")
    public HashMap<String,Object> addUser(User user){
        log.info("user-->" + JSON.toJSONString(user));
        HashMap<String, Object> map = userService.addUser(user);
        return map;
    }

    @PostMapping("editUser")
    public HashMap<String,Object> editUser(User user){
        log.info("user-->" + JSON.toJSONString(user));
        HashMap<String, Object> map = userService.updateUser(user);
        return map;
    }

    @PostMapping("deleteUsers")
    public HashMap<String,Object> deleteUser(@RequestBody List<User> users){
        log.info("users-->" + JSON.toJSONString(users));
        HashMap<String, Object> map = userService.deleteUser(users);
        return map;
    }
}
