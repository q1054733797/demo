package com.demo.springboot.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

/**
 * @ClassName: WebSocket
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 15:25
 * @Version: 1.0
 */
@ServerEndpoint("/webSocketServer")
@Component
public class WebSocket {
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
    }

    public void sendMessage(String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    @OnMessage
    public void onMessage(String message) throws IOException {
        System.out.println("接收到浏览器的信息:" + message);
        String date = DateFormat.getDateTimeInstance().format(new Date());
        sendMessage(date);
    }
}
