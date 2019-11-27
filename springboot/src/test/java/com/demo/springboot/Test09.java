package com.demo.springboot;

import com.demo.springboot.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test09
 * @date : Create in 2019/9/10 14:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Test09 {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test01(){
        User user = new User();
//        user.setUsername("admin");
//        redisTemplate.opsForValue().set("name",user);
        redisTemplate.delete("name");
        System.out.println(user);
        log.info("添加成功");
    }
}
