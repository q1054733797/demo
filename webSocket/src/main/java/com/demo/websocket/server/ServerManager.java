package com.demo.websocket.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ServerManager
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/18 9:12
 * @Version: 1.0
 */
public class ServerManager {
    private static List<Server> servers = new ArrayList<>();

    public static void broadCast(String message){
        for (Server server : servers) {
            try {
                server.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getTotal(){
        return servers.size();
    }

    public static void add(Server server){
        servers.add(server);
        System.out.println("有新连接加入，当前连接数为：" + servers.size());
    }

    public static void remove(Server server){
        servers.remove(server);
        System.out.println("有连接退出，当前连接数为：" + servers.size());
    }
}
