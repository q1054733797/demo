package com.demo.springsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Test01
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 10:01
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("000000"));
    }
}
