package com.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.demo.springboot.mapper.AdjustMapper;
import com.demo.springboot.pojo.BatchAdjustInfo;
import com.demo.springboot.pojo.ImpBatchAdjustReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : AdjustTest
 * @date : Create in 2019/11/9 14:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AdjustTest {
    @Autowired
    private AdjustMapper adjustMapper;

    @Test
    public void test() throws IOException {
        List<BatchAdjustInfo> adjustInfos = adjustMapper.getAdjustInfos();
        log.info("需要调账的条数" + adjustInfos.size());
        ImpBatchAdjustReq req = new ImpBatchAdjustReq();
        req.setAdjustInfos(adjustInfos);
        log.info(JSON.toJSONString(req));
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String url = "http://137.0.250.173:8191/billsrv/local/acctOA/impBatchAdjust";
        HttpPost httpPost = new HttpPost(url);
        StringEntity stringEntity = new StringEntity(JSON.toJSONString(req), "UTF-8");
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        log.info("响应类型:" + response.getStatusLine());
        log.info("响应长度:" + entity.getContentLength());
        log.info("响应内容:" + EntityUtils.toString(entity));
    }
}
