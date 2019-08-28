package com.demo.springsecurity.controller;

import com.demo.springsecurity.pojo.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/28 10:54
 * @Version: 1.0
 */
@Controller
public class TestController {
    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping("hasRole")
    @ResponseBody
    public String hasRole(){
        return "hasRole";
    }

    @RequestMapping("hasAuthority")
    @ResponseBody
    public String hasAuthority(){
        return "hasAuthority";
    }

    public void update(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(authentication.getAuthorities());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_VIP"));
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(),grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);
    }
}
