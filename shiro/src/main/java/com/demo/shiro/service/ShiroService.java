package com.demo.shiro.service;

import com.demo.shiro.bean.User;

import java.util.Set;

/**
 * @ClassName: ShiroService
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/16 10:22
 * @Version: 1.0
 */
public interface ShiroService {
    User getUserByUsername(String username);

    Set<String> getRolesByUsername(String username);

    Set<String> getPermissionsByUsername(String username);
}
