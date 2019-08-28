package com.demo.springsecurity.configuration;

import com.demo.springsecurity.mapper.UserMapper;
import com.demo.springsecurity.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WebSecuriryConfig
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/27 9:42
 * @Version: 1.0
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserMapper userMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/hasRole").hasRole("TEST")
                .antMatchers("/hasAuthority").hasAuthority("TEST")
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().logout().permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            User user = userMapper.getUserByUsername(username);
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_TEST"));
            authorities.add(new SimpleGrantedAuthority("TEST"));
            user.setAuthorities(authorities);
            return user;
        }).passwordEncoder(new BCryptPasswordEncoder());
        //.passwordEncoder(new BCryptPasswordEncoder());
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("admin").
//                password("$2a$10$CAnizTJwcXtiPinkhFyv1Op0cGdXJ8oD7.ZzqZ5.67DzCx8eiXPs2")
//                .roles("USER");
    }
}
