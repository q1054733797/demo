package com.demo.springboot.service;

import com.demo.springboot.pojo.EasyUIDatagridResult;
import com.demo.springboot.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: UserService
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/14 14:44
 * @Version: 1.0
 */
public interface UserService {
    EasyUIDatagridResult getUsers(String page, String rows, User user);
    HashMap<String,Object> addUser(User user);
    HashMap<String,Object> deleteUser(List<User> users);
    HashMap<String,Object> updateUser(User user);
}
