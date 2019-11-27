package com.demo.springboot;

import java.io.IOException;
import java.util.Properties;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test10
 * @date : Create in 2019/9/18 16:40
 */
public class Test10 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
        properties.forEach((key,val) -> {
            System.out.println(key + "=" + val);
        });
    }
}
