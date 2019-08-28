package com.demo.springboot.mapper;

import com.demo.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: UserMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/14 14:37
 * @Version: 1.0
 */
@Mapper
public interface UserMapper {
    @SelectProvider(type = UserProvider.class,method = "getUsers")
    List<User> getUsers(User user);

    @Insert("insert into t_user(username,password,realName) values(#{username},#{password},#{realName})")
    int addUser(User user);

    @DeleteProvider(type = UserProvider.class,method = "deleteUsers")
    int deleteUsers(List<User> users);

    @Update("update t_user set username = #{username},password = #{password},realName = #{realName} where id = #{id}")
    int updateUser(User user);
}
