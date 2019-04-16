package com.demo.shiro;

import com.demo.shiro.util.ShiroUtil;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName: RoleTest
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/11 10:46
 * @Version: 1.0
 */
public class RoleTest {
    public static void main(String[] args) {
        Subject user = ShiroUtil.getSubject("classpath:shiroRole.ini", "admin", "123456");
        if(user.isAuthenticated()){
            System.out.println(user.hasRole("**"));
        }
    }
}
