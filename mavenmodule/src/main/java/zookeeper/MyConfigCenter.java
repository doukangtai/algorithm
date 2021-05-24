package zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/20
 */
public class MyConfigCenter {

    String ip = "192.168.83.132:2181";
    ZooKeeper zooKeeper;

    private String url;
    private String username;
    private String password;

    @Before
    public void before() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper(ip, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.None) {
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("连接建立成功");
                        countDownLatch.countDown();
                    } else if (watchedEvent.getState() == Event.KeeperState.Disconnected) {
                        System.out.println("断开连接");
                    } else if (watchedEvent.getState() == Event.KeeperState.Expired) {
                        System.out.println("会话超时");
                        try {
                            zooKeeper = new ZooKeeper(ip, 5000, this);
                            countDownLatch.await();
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else if (watchedEvent.getState() == Event.KeeperState.AuthFailed) {
                        System.out.println("认证失败");
                    }
                } else if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    try {
                        zooKeeper = new ZooKeeper(ip, 5000, this);
                        countDownLatch.await();
                        test1();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        countDownLatch.await();
    }

    @After
    public void after() throws Exception {
        zooKeeper.close();
    }

    @Test
    public void test1() throws Exception {
        this.url = new String(zooKeeper.getData("/config/url", true, null));
        this.username = new String(zooKeeper.getData("/config/username", true, null));
        this.password = new String(zooKeeper.getData("/config/password", true, null));
    }

    @Test
    public void test2() throws Exception {
        test1();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(5000);
            System.out.println("url: " + this.url);
            System.out.println("username: " + this.username);
            System.out.println("password: " + this.password);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
