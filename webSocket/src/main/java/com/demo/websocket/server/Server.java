package com.demo.websocket.server;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @ClassName: Server
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/18 8:58
 * @Version: 1.0
 */
@ServerEndpoint("/server")
public class Server {
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        ServerManager.add(this);
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onClose() {
        ServerManager.remove(this);
    }

    @OnMessage
    public void onMessage(String message,Session session){
        System.out.println("来自客户端的信息:" + message);
        if(message.contains("广播:")){
            ServerManager.broadCast(message.substring(message.indexOf("广播:")));
        }else{
            int total = ServerManager.getTotal();
            try {
                sendMessage("接收到客户端消息:" + message + ",当前连接人数为:" + total);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("出现错误");
    }
}
