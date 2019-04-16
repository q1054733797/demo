package com.demo.shiro.service.impl;

import com.demo.shiro.bean.User;
import com.demo.shiro.mapper.ShiroMapper;
import com.demo.shiro.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @ClassName: ShiroServiceImpl
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/16 10:22
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private ShiroMapper shiroMapper;

    @Override
    public User getUserByUsername(String username) {
        return shiroMapper.getUserByUsername(username);
    }

    @Override
    public Set<String> getRolesByUsername(String username) {
        return shiroMapper.getRolesByUsername(username);
    }

    @Override
    public Set<String> getPermissionsByUsername(String username) {
        return shiroMapper.getPermissionsByUsername(username);
    }
}
