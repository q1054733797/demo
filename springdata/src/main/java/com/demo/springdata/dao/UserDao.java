package com.demo.springdata.dao;

import com.demo.springdata.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName: UserDao
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/6 14:43
 * @Version: 1.0
 */
public interface UserDao extends JpaRepository<User,Integer> {
    //List<User> queryAll();
}
