package zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;
import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/20
 */
public class ZookeeperConnectionWatcher implements Watcher {
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static ZooKeeper zooKeeper;

    public static void main(String[] args) {
        try {
            zooKeeper = new ZooKeeper("192.168.83.132:2181", 5000, new ZookeeperConnectionWatcher());
            countDownLatch.await();
            System.out.println(zooKeeper.getSessionId());
            zooKeeper.addAuthInfo("digest1", "itcast1:1123456".getBytes());
            byte[] data = zooKeeper.getData("/node1", false, null);
            System.out.println(new String(data));
            Thread.sleep(1000);
            zooKeeper.close();
            System.out.println("END");
        } catch (IOException | InterruptedException | KeeperException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("连接建立成功");
            countDownLatch.countDown();
        } else if (watchedEvent.getState() == Event.KeeperState.Disconnected) {
            System.out.println("断开连接");
        } else if (watchedEvent.getState() == Event.KeeperState.Expired) {
            System.out.println("会话超时");
        } else if (watchedEvent.getState() == Event.KeeperState.AuthFailed) {
            System.out.println("认证失败");
        }
    }

    @Test
    public void test1() throws NoSuchAlgorithmException {
        System.out.println(DigestAuthenticationProvider.generateDigest("super:admin"));
    }
}
