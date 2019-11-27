package com.demo.springboot.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
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
@DS("oracle")
public interface UserMapper {
    @SelectProvider(type = UserProvider.class,method = "getUsers")
    List<User> getUsers(User user);

    @Select("select * from t_user where username = #{username}")
    User getUser(User user);

    @Insert("insert into t_user(username,password,realName) values(#{username},#{password},#{realName})")
    int addUser(User user);

    @DeleteProvider(type = UserProvider.class,method = "deleteUsers")
    int deleteUsers(List<User> users);

    @Update("update t_user set username = #{username},password = #{password} where id = #{id}")
    int updateUser(User user);
}
