package zookeeper;

import org.apache.zookeeper.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/20
 */
public class ZkWatcherExists {

    String ip = "192.168.83.132:2181";
    ZooKeeper zooKeeper;

    @Before
    public void before() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(ip, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接建立成功！");
                    countDownLatch.countDown();
                }
                System.out.println("watchedEvent.getPath: " + watchedEvent.getPath());
                System.out.println("watchedEvent.getType: " + watchedEvent.getType());
            }
        });
        countDownLatch.await();
    }

    @After
    public void after() throws Exception {
        zooKeeper.close();
    }

    @Test
    public void watcherExists1() throws Exception {
        zooKeeper.exists("/watcher1", true);
        Thread.sleep(10000);
        System.out.println("END");
    }

    @Test
    public void watcherExists2() throws Exception {
        zooKeeper.exists("/watcher1", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("自定义Watcher");
                System.out.println(watchedEvent.getPath());
                System.out.println(watchedEvent.getType());
                try {
                    zooKeeper.exists("/watcher1", this);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread.sleep(100000);
        System.out.println("END");
    }
}
