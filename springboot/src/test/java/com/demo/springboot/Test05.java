package com.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.errcode.ErrorCode;
import com.demo.springboot.pojo.Student;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.Valid;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: Test05
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/23 15:50
 * @Version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test05 {
    @Autowired
    private Environment env;

    public static void main(String[] args) throws IOException {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        Process process = Runtime.getRuntime().exec("ping 137.0.58.233");
        System.out.println(IOUtils.toString(process.getInputStream(),"GBK"));
    }

    @Test
    public void test(){
        System.out.println(env.getProperty("spring.thymeleaf.cache"));
    }
}
