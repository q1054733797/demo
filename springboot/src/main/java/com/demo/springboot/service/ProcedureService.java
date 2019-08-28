package com.demo.springboot.service;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @ClassName: ProcedureService
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/22 14:23
 * @Version: 1.0
 */
@Service
public class ProcedureService {
    private DefaultMQProducer producer;

    public boolean sendMessage(String topic,String tags,String content){
        Message message = new Message(topic, tags, content.getBytes());
        try {
            producer.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @PostConstruct
    public void iniMQProcedure(){
        producer = new DefaultMQProducer("defaultGroup");
        producer.setNamesrvAddr("192.168.230.129:9876");
        producer.setRetryTimesWhenSendFailed(3);
        try {
            producer.start();
        }catch (Exception e){

        }
    }

    @PreDestroy
    public void shutDownProcedure(){
        if(producer != null){
            producer.shutdown();
        }
    }
}
