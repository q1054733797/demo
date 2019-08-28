package com.demo.springsecurity.mapper;

import com.demo.springsecurity.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: UserMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 9:48
 * @Version: 1.0
 */
@Mapper
@Repository
public interface UserMapper {
    @Select("select * from t_user where username = #{username}")
    User getUserByUsername(@Param("username") String username);
}
