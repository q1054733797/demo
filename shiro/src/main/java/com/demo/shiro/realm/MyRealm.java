package com.demo.shiro.realm;

import com.demo.shiro.bean.User;
import com.demo.shiro.mapper.ShiroMapper;
import com.demo.shiro.service.ShiroService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @ClassName: MyRealm
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/15 9:50
 * @Version: 1.0
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.getPrimaryPrincipal().toString();
        AuthorizationInfo authorizationInfo = null;
        try {
            Set<String> roles = shiroService.getRolesByUsername(username);
            Set<String> permissions = shiroService.getPermissionsByUsername(username);
            authorizationInfo = new SimpleAuthorizationInfo(roles);
            ((SimpleAuthorizationInfo) authorizationInfo).addStringPermissions(permissions);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        AuthenticationInfo authenticationInfo = null;
        try {
            User user = shiroService.getUserByUsername(username);
            if(user != null){
                authenticationInfo = new SimpleAuthenticationInfo(username,user.getPassword(),getName());
            }else{
                System.out.println("该用户不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取用户失败");
        }
        return authenticationInfo;
    }
}
