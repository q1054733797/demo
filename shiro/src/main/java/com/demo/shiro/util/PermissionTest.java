package com.demo.shiro.util;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;

/**
 * @ClassName: PermissionTest
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/11 11:10
 * @Version: 1.0
 */
public class PermissionTest {
@RequiresAuthentication()
    public static void main(String[] args) {
        Subject user = ShiroUtil.getSubject("classpath:shiroPermission.ini", "admin", "123456");
        if(user.isAuthenticated()){
            System.out.println(user.isPermitted("addUser"));
        }else{
            System.out.println("用户未登录");
        }
    }
}
