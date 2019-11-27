package com.demo.springboot.service.impl;

import com.demo.springboot.pojo.User;
import com.demo.springboot.service.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : TestServiceImpl
 * @date : Create in 2019/10/9 16:04
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    public List<User> addTest() {
        List<User> list = new ArrayList<>();
        User user = null;
        for(int i=0;i<10;i++){
            user = new User();
            user.setUsername("admin");
            list.add(user);
        }
        return list;
    }
}
