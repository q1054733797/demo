package com.demo.shiro.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * @ClassName: ShiroUtil
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/11 10:43
 * @Version: 1.0
 */
public class ShiroUtil {
    public static Subject getSubject(String resourceFile,String username,String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(resourceFile);
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            System.out.println("登录失败");
        }
        return subject;
    }
}
