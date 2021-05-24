package zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/20
 */
public class GlobalUniqueId implements Watcher {

    String ip = "192.168.83.132:2181";
    ZooKeeper zooKeeper;
    String defaultPath = "/uniqueId";
    CountDownLatch countDownLatch = new CountDownLatch(1);

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            if (watchedEvent.getType() == Event.EventType.None) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接建立成功");
                    countDownLatch.countDown();
                } else if (watchedEvent.getState() == Event.KeeperState.Disconnected) {
                    System.out.println("断开连接");
                } else if (watchedEvent.getState() == Event.KeeperState.Expired) {
                    System.out.println("会话超时");
                    zooKeeper = new ZooKeeper(ip, 5000, new GlobalUniqueId());
                } else if (watchedEvent.getState() == Event.KeeperState.AuthFailed) {
                    System.out.println("认证失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GlobalUniqueId() {
        try {
            zooKeeper = new ZooKeeper(ip, 5000, this);
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUniqueId() {
        String path = "";
        try {
            path = zooKeeper.create(defaultPath, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path.substring(8);
    }

    public static void main(String[] args) {
        GlobalUniqueId globalUniqueId = new GlobalUniqueId();
        for (int i = 0; i < 5; i++) {
            System.out.println(globalUniqueId.getUniqueId());
        }
    }
}
