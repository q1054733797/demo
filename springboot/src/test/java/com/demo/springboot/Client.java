package com.demo.springboot;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @ClassName: Client
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/30 19:21
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(outputStream);
        DataInputStream dis = new DataInputStream(inputStream);
        String message = null;
        System.out.println("连接成功，请输入消息");
        Scanner scanner = new Scanner(System.in);
        message = scanner.nextLine();
        dos.writeUTF(message);
        //IOUtils.write(message, outputStream, "UTF-8");
        while (true){
            message = dis.readUTF();
            if(StringUtils.isNotEmpty(message)){
                System.out.println("接收到服务器返回消息:" + message);
                if(message.equals("连接已关闭，再见")){
                    System.out.println("客户端已关闭");
                    socket.close();
                    break;
                }
                System.out.println("请输入消息");
                scanner = new Scanner(System.in);
                message = scanner.nextLine();
                dos.writeUTF(message);
            }
        }
    }
}
