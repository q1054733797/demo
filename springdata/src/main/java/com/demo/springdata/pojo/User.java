//package com.demo.springdata.pojo;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
///**
// * @ClassName: User
// * @Author: zhanghongkai
// * @Date: Create in 2019/6/6 14:40
// * @Version: 1.0
// */
//@Entity
//@Table(name = "t_user")
//public class User implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String realName;
//    private String username;
//    private String password;
//
//    public User() {
//    }
//
//    public User(String realName, String username, String password) {
//        this.realName = realName;
//        this.username = username;
//        this.password = password;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getRealName() {
//        return realName;
//    }
//
//    public void setRealName(String realName) {
//        this.realName = realName;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", realName='" + realName + '\'' +
//                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
//}
