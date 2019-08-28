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

    private List<GrantedAuthority> authorities;

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
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
