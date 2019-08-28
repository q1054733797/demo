package com.demo.springboot.service.impl;

import com.demo.springboot.mapper.UserMapper;
import com.demo.springboot.pojo.EasyUIDatagridResult;
import com.demo.springboot.pojo.User;
import com.demo.springboot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/14 14:55
 * @Version: 1.0
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public EasyUIDatagridResult getUsers(String page, String rows, User user) {
        Page<Object> pageHelper = PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows)).setReasonable(true);
        List<User> users = userMapper.getUsers(user);
        EasyUIDatagridResult<User> result = new EasyUIDatagridResult<>();
        result.setTotal(Integer.valueOf(String.valueOf(pageHelper.getTotal())));
        result.setRows(users);
        return result;
    }

    @Override
    public HashMap<String,Object> addUser(User user) {
        HashMap<String,Object> map = new HashMap<>();
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        if(userMapper.addUser(user) > 0){
            map.put("resultMsg", "添加成功");
            map.put("resultCode", 0);
        }else{
            map.put("resultMsg", "添加失败");
            map.put("resultCode", 1);
        }
        return map;
    }

    @Override
    public HashMap<String,Object> deleteUser(List<User> users) {
        HashMap<String,Object> map = new HashMap<>();
        if(userMapper.deleteUsers(users) > 0){
            map.put("resultMsg", "删除成功");
            map.put("resultCode", 0);
        }else{
            map.put("resultMsg", "删除失败");
            map.put("resultCode", 1);
        }
        return map;
    }

    @Override
    public HashMap<String,Object> updateUser(User user) {
        HashMap<String,Object> map = new HashMap<>();
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        if(userMapper.updateUser(user) > 0){
            map.put("resultMsg", "修改成功");
            map.put("resultCode", 0);
        }else{
            map.put("resultMsg", "修改失败");
            map.put("resultCode", 1);
        }
        return map;
    }
}
