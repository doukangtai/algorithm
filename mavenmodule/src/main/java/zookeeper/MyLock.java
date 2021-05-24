package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/20
 */
public class MyLock {

    String ip = "192.168.83.132:2181";
    ZooKeeper zooKeeper;
    CountDownLatch countDownLatch = new CountDownLatch(1);
    private static final String LOCK_ROOT_Path = "/Locks";
    private static final String LOCK_NODE_NAME = "Lock_";
    private String lockPath;

    public MyLock() {
        try {
            zooKeeper = new ZooKeeper(ip, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getType() == Event.EventType.None) {
                        if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                            System.out.println("建立连接成功");
                            countDownLatch.countDown();
                        }
                    }
                }
            });
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acquireLock() throws Exception {
        createLock();
        attemptLock();
    }

    private void createLock() throws Exception {
        Stat stat = zooKeeper.exists(LOCK_ROOT_Path, false);
        if (stat == null) {
            zooKeeper.create(LOCK_ROOT_Path, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        lockPath = zooKeeper.create(LOCK_ROOT_Path + "/" + LOCK_NODE_NAME, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("节点创建成功：" + lockPath);
    }

    Watcher watcher = new Watcher() {
        @Override
        public void process(WatchedEvent watchedEvent) {
            if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                synchronized (this) {
                    this.notifyAll();
                }
            }
        }
    };

    private void attemptLock() throws Exception {
        List<String> list = zooKeeper.getChildren(LOCK_ROOT_Path, false);
        Collections.sort(list);
        int index = list.indexOf(lockPath.substring(LOCK_ROOT_Path.length() + 1));
        if (index == 0) {
            System.out.println("获取锁成功");
            return;
        } else {
            String path = list.get(index - 1);
            Stat stat = zooKeeper.exists(LOCK_ROOT_Path + "/" + path, watcher);
            if (stat == null) {
                attemptLock();
            } else {
                synchronized (watcher) {
                    watcher.wait();
                }
                attemptLock();
            }
        }
    }

    public void releaseLock() throws Exception {
        zooKeeper.delete(this.lockPath, -1);
        zooKeeper.close();
        System.out.println("锁释放：" + this.lockPath);
    }

    public static void main(String[] args) {
        try {
            MyLock myLock = new MyLock();
            myLock.acquireLock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
