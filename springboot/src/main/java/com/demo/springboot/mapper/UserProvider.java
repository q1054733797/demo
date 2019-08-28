package com.demo.springboot.mapper;

import com.demo.springboot.pojo.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @ClassName: UserProvider
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/15 19:06
 * @Version: 1.0
 */
public class UserProvider {
    public String getUsers(User user){
        SQL sql = new SQL();
        sql.FROM("t_user");
        sql.SELECT("*");
        if(!StringUtils.isBlank(user.getUsername())){
            sql.WHERE("username like concat('%',#{username},'%')");
        }
        if(!StringUtils.isBlank(user.getRealName())){
            sql.WHERE("realName like concat('%',#{realName},'%')");
        }
        return sql.toString();
    }

    public String deleteUsers(@Param("list") List<User> users){
        SQL sql = new SQL();
        sql.DELETE_FROM("t_user");
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.getId()).append(",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sql.WHERE("id in (" + sb.toString() + ")");
        System.out.println(sql.toString());
        return sql.toString();
    }
}
