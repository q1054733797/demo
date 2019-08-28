package com.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.pojo.Student;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: Test06
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/31 15:36
 * @Version: 1.0
 */
public class Test06 {
    public static void main(String[] args) throws IOException, URISyntaxException {
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        String url = "http://127.0.0.1:8082/demo/test02";
////        HttpGet httpGet = new HttpGet(url);
////        CloseableHttpResponse response = httpClient.execute(httpGet);
//        HttpPost httpPost = new HttpPost(url);
//        Student student = new Student();
//        student.setStudentName("张鸿凯");
//        student.setStudentId(1);
//        String studentStr = JSON.toJSONString(student);
//        System.out.println(studentStr);
//        StringEntity stringEntity = new StringEntity(studentStr, "UTF-8");
//        httpPost.setEntity(stringEntity);
//        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
////        List<NameValuePair> nameValuePairs = new ArrayList<>();
////        nameValuePairs.add(new BasicNameValuePair("studentName", "张三"));
////        nameValuePairs.add(new BasicNameValuePair("studentId", "2"));
////        URI uri = new URIBuilder().setScheme("http")
////                .setHost("localhost")
////                .setPort(8082)
////                .setPath("/demo/test02")
////                .setParameters(nameValuePairs)
////                .build();
////        HttpPost httpPost = new HttpPost(uri);
//        CloseableHttpResponse response = httpClient.execute(httpPost);
//        HttpEntity entity = response.getEntity();
//        System.out.println("响应类型:" + response.getStatusLine());
//        System.out.println("响应长度:" + entity.getContentLength());
//        System.out.println("响应内容:" + EntityUtils.toString(entity));
    }
}
