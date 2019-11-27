package com.demo.springboot;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName: NettyClient
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/8 15:34
 * @Version: 1.0
 */
@Slf4j
public class NettyClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1",12345);
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        PrintWriter writer = new PrintWriter(outputStream);
        writer.println("P10000630000000000000000000000000000N0531T0531");
        writer.flush();
        Thread.sleep(1000);
        writer.println("|15305435009|");
        writer.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(reader.readLine());
//        Bootstrap bootstrap = new Bootstrap();
//        bootstrap.group(new NioEventLoopGroup())
//                .channel(NioSocketChannel.class)
//                .handler(new ChannelInitializer<Channel>() {
//                    @Override
//                    protected void initChannel(Channel channel) throws Exception {
//                        channel.pipeline().addLast(new StringEncoder());
//                    }
//                });
//        Channel channel = bootstrap.connect("127.0.0.1", 12345).channel();
//        channel.writeAndFlush("what the fuck");
    }
}
