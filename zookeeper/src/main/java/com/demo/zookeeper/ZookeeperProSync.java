package com.demo.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: ZookeeperProSync
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/19 15:34
 * @Version: 1.0
 */
public class ZookeeperProSync implements Watcher {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception {
        String path = "/username";
        zooKeeper = new ZooKeeper("localhost:2181", 5000, new ZookeeperProSync());
        countDownLatch.await();
        System.out.println(new String(zooKeeper.getData(path, true, stat)));
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
            if(Event.EventType.None == watchedEvent.getType()){
                countDownLatch.countDown();
            }else if(Event.EventType.NodeDataChanged == watchedEvent.getType()){
                try {
                    System.out.println("配置已修改,新值为:" + new String(zooKeeper.getData(watchedEvent.getPath(), true, stat)));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
