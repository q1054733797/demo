package com.demo.shiro;

import com.demo.shiro.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @ClassName: HelloWorld
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/11 9:28
 * @Version: 1.0
 */
public class HelloWorld {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        if(loginUser(user)){
            System.out.printf("登录成功,帐号为：%s，密码为：%s",user.getUsername(),user.getPassword());
        }
        if(hasRole(user,"test")){
            System.out.println(user.getUsername() + "拥有角色:" + "admin");
        }
        if(isPermitted(user,"add")){
            System.out.println(user.getUsername() + "拥有权限:" + "admin");
        }
    }

    private static boolean isPermitted(User user,String permitted){
        Subject subject = getSubject();
        if(!subject.isAuthenticated()){
            loginUser(user);
        }
        return subject.isPermitted(permitted);
    }

    private static boolean  hasRole(User user,String role){
        Subject subject = getSubject();
        if(!subject.isAuthenticated()){
            loginUser(user);
        }
        return subject.hasRole(role);
    }

    private static boolean loginUser(User user){
        Subject subject = getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private static Subject getSubject(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        return SecurityUtils.getSubject();
    }
}
