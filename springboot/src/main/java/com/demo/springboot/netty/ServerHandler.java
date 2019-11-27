package com.demo.springboot.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @ClassName: ServerHandler
 * @Author: zhanghongkai
 * @Date: Create in 2019/8/30 15:19
 * @Version: 1.0
 */
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    private ChannelCache channelCache;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object message) throws InterruptedException {
        ByteBuf byteBuf = Unpooled.buffer();
        try {
            byteBuf.clear();
            byteBuf.writeBytes(message.toString().getBytes());
            //获取参数
            String msg = message.toString();
            System.out.println(msg  + "-->" + msg.length());

            //获取通道id
            String channelId = ctx.channel().id().asLongText();
            //缓存消息
            channelCache.addChannelMsg(channelId, msg);
            //获取缓存后的消息内容
            StringBuilder channelMsg = channelCache.getChannelMsg(channelId);
            //去掉消息中的\r\n
            String block = channelMsg.toString().replace("\r", "").replace("\n", "");

            //获取报文大小
            Integer packSize = Integer.valueOf(StringUtils.substring(block, 4, 8));
            System.out.println("packSize-->" + packSize);
            System.out.println("channelMsgSize-->" + channelMsg.length());
            if(channelMsg.length() == packSize) {
                System.out.println(byteBuf.toString(Charset.forName("UTF-8")));
                System.out.println(channelId);
                ctx.channel().writeAndFlush(msg);
                ctx.channel().close();
            }

        }catch (Exception e){
            e.printStackTrace();
            byteBuf.clear();
            byteBuf.writeBytes(e.getMessage().getBytes());
            ctx.channel().writeAndFlush(byteBuf);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String type = "";
            if (event.state() == IdleState.READER_IDLE) {
                type = "read idle";
            } else if (event.state() == IdleState.WRITER_IDLE) {
                type = "write idle";
            } else if (event.state() == IdleState.ALL_IDLE) {
                type = "all idle";
            }
            ctx.channel().writeAndFlush(type);
        } else {

        }
    }

    public void test(){
        System.out.println("处理了");
    }
}
