package com.demo.springboot;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test15
 * @date : Create in 2019/9/24 20:16
 */
@WebService
public class Test15 {
    public String test01(){
        return "hello world";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/test", new Test15());
        System.out.println("发布成功");
    }
}
