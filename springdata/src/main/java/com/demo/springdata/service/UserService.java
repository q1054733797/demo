package com.demo.springdata.service;
//
//import com.demo.springdata.dao.UserDao;
//import com.demo.springdata.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;

/**
 * @ClassName: UserService
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/6 14:46
 * @Version: 1.0
 */
//@Service
//@Transactional
//public class UserService {
//    @Autowired
//    private UserDao userDao;
//
//    public List<User> getUsers(){
//        return userDao.findAll();
//    }
//
//    public User getUserById(int id){
//        return userDao.findById(id).orElse(null);
//    }
//
//    public User addUser(User user){
//        user = userDao.save(user);
//        return user;
//    }
//
//    public void deleteUser(User user){
//        userDao.delete(user);
//    }
//
//    public User updateUser(User user){
//        user = userDao.save(user);
//        return user;
//    }
//}
