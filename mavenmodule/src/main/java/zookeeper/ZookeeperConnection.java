package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/18
 */
public class ZookeeperConnection {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper("192.168.83.128:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接建立成功！");
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getSessionId());
        zooKeeper.close();
    }
}
