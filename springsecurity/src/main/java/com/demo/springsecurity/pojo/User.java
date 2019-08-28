package com.demo.springsecurity.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

/**
 * @ClassName: User
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 9:23
 * @Version: 1.0
 */
@Data
public class User implements UserDetails {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String id;
    private Long createTime = System.currentTimeMillis();
    private String username;
    private String password;
    private String realName;
    private String type;
    private Map<String, Object> associatedResources = new HashMap<>();
    /**
     * 用户关注的企业列表
     */
    private List<String> favourite = new ArrayList<>();

    /**
     * 用户在系统中的角色列表，将根据角色对用户操作权限进行限制
     */
    private List<String> roles = new ArrayList<>();

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(this.username != null){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.username);
            authorities.add(authority);
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
