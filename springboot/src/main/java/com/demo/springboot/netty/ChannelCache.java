package com.demo.springboot.netty;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : ChannelCache
 * @date : Create in 2019/10/30 18:55
 */
@Component
public class ChannelCache {
    private HashMap<String,StringBuilder> map = new HashMap<>();

    public void addChannelMsg(String channelId,String msg){
        if(map.get(channelId) != null){
            map.put(channelId, map.get(channelId).append(msg));
        }else{
            map.put(channelId, new StringBuilder().append(msg));
        }
    }

    public StringBuilder getChannelMsg(String channelId){
        return map.get(channelId);
    }

    public StringBuilder deleteChannelMsg(String channelId){
        return map.remove(channelId);
    }
}
