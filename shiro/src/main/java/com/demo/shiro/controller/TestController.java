package com.demo.shiro.controller;

import com.demo.shiro.bean.User;
import com.demo.shiro.service.ShiroService;
import com.demo.shiro.util.PryptographyUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: TestController
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/16 10:14
 * @Version: 1.0
 */
@Controller
public class TestController {
    @Autowired
    private ShiroService shiroService;

    @RequestMapping("login")
    public ModelAndView login(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        password = PryptographyUtil.encodeMd5(password, "admin");
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        ModelAndView modelAndView = null;
        try {
            subject.login(usernamePasswordToken);
            modelAndView = new ModelAndView("success");
        } catch (AuthenticationException e) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("errorMsg", "帐号或密码错误");
        }
        return modelAndView;
    }
}
