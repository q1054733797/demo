package com.demo.springboot;

import cn.hutool.http.Header;
import com.alibaba.fastjson.JSON;
import com.demo.springboot.pojo.Student;
import io.netty.handler.codec.HeadersUtils;
import org.apache.http.Consts;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test16
 * @date : Create in 2019/9/24 21:57
 */
public class Test16 {
    public static void main(String[] args) throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost("http://www.baidu.com");
        for(int i=0;i<10;i++){
            Student student = new Student();
            student.setStudentId(1);
            student.setStudentName("张鸿凯");
            post.setEntity(new StringEntity(JSON.toJSONString(student), ContentType.APPLICATION_JSON));
            CloseableHttpResponse response = client.execute(post);
            System.out.println(EntityUtils.toString(response.getEntity(), Consts.UTF_8));
            response.close();
        }
        client.close();
    }
}
