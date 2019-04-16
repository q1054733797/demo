package com.demo.shiro.mapper;

import com.demo.shiro.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @ClassName: ShiroMapper
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/15 9:59
 * @Version: 1.0
 */
@Mapper
public interface ShiroMapper {
    @Select("select * from t_user where username = #{username}")
    User getUserByUsername(String username);

    @Select("select a.name from t_role a " +
            "join t_user_role b on a.id = b.roleId " +
            "join t_user c on b.userId = c.id and c.username = #{username}")
    Set<String> getRolesByUsername(String username);

    @Select("select a.name from t_permission a " +
            "join t_role_permission b on a.id = b.permissionId " +
            "join t_role c on b.roleId = c.id " +
            "join t_user_role d on c.id = d.roleId " +
            "join t_user e on d.userId = e.id and e.username = #{username}")
    Set<String> getPermissionsByUsername(String username);
}
