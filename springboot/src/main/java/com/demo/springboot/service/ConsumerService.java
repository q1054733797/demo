package com.demo.springboot.service;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * @ClassName: ConsumerService
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/22 14:30
 * @Version: 1.0
 */
@Service
public class ConsumerService {
    private DefaultMQPushConsumer consumer;

    @PostConstruct
    public void initConsumer(){
        consumer = new DefaultMQPushConsumer("defaultGroup");
        consumer.setNamesrvAddr("192.168.230.129:9876");
        try {
            consumer.subscribe("demo", "tag-a");
            consumer.registerMessageListener((List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) -> {
                for (MessageExt messageExt : list) {
                    System.out.println("接收到消息:" + new String(messageExt.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void shutdownConsumer(){
        if(consumer != null){
            consumer.shutdown();
        }
    }
}
