package com.demo.springboot;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Server
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/30 19:21
 * @Version: 1.0
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        DataInputStream dis = new DataInputStream(inputStream);
        String message = null;
        while (true){
            message = dis.readUTF();
            if(StringUtils.isNotEmpty(message)){
                System.out.println("收到客户端的消息:" + message);
                if(message.equals("exit")){
                    dos.writeUTF("连接已关闭，再见");
                    socket.close();
                    break;
                }else{
                    dos.writeUTF("服务器收到消息:" + message + ",如果关闭连接，请输入exit");
                }
            }
        }
    }
}
