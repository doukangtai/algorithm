package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author 窦康泰
 * @date 2021/05/18
 */
public class ZkCreate {

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
            }
        });
        countDownLatch.await();
    }

    @After
    public void after() throws Exception {
        zooKeeper.close();
    }

    @Test
    public void create1() throws Exception {
        zooKeeper.create("/create/node1", "node1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void create2() throws Exception {
        zooKeeper.create("/create/node2", "node2".getBytes(), ZooDefs.Ids.READ_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void create3() throws Exception {
        List<ACL> acls = new ArrayList<>();
        Id id = new Id("world", "anyone");
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        acls.add(new ACL(ZooDefs.Perms.WRITE, id));
        zooKeeper.create("/create/node3", "node3".getBytes(), acls, CreateMode.PERSISTENT);
    }

    @Test
    public void create4() throws Exception {
        List<ACL> acls = new ArrayList<>();
        Id id = new Id("ip", "192.168.83.128");
        acls.add(new ACL(ZooDefs.Perms.ALL, id));
        zooKeeper.create("/create/node4", "node4".getBytes(), acls, CreateMode.PERSISTENT);
    }

    @Test
    public void create5() throws Exception {
        Stat stat = zooKeeper.setData("/set/node1", "node11".getBytes(), -1);
        System.out.println(stat.getVersion());
    }

    @Test
    public void create6() throws Exception {
        zooKeeper.setData("/set/node1", "node13".getBytes(), -1, new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int i, String s, Object o, Stat stat) {
                System.out.println(i);
                System.out.println(s);
                System.out.println(o);
                System.out.println(stat.getVersion());
            }
        }, "I am ctx");
        Thread.sleep(1000);
        System.out.println("END");
    }

    @Test
    public void create7() throws Exception {
        zooKeeper.delete("/delete/node1", -1);
    }

    @Test
    public void create8() throws Exception {
        zooKeeper.delete("/delete/node2", -1, new AsyncCallback.VoidCallback() {
            @Override
            public void processResult(int i, String s, Object o) {
                System.out.println(i);
                System.out.println(s);
                System.out.println(o);
            }
        }, "I am ctx");
        Thread.sleep(1000);
        System.out.println("END");
    }

    @Test
    public void create9() throws Exception {
        byte[] data = zooKeeper.getData("/get/node1", false, new Stat());
        System.out.println(new String(data));
    }

    @Test
    public void create10() throws Exception {
        zooKeeper.getData("/get/node1", false, new AsyncCallback.DataCallback() {
            @Override
            public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
                System.out.println(i);
                System.out.println(s);
                System.out.println(o);
                System.out.println(new String(bytes));
                System.out.println(stat.getVersion());
            }
        }, "I am ctx");
        Thread.sleep(1000);
        System.out.println("END");
    }

    @Test
    public void create11() throws Exception {
        List<String> children = zooKeeper.getChildren("/get", false);
        for (String child : children) {
            System.out.println(child);
        }
    }

    @Test
    public void create12() throws Exception {
        zooKeeper.getChildren("/get", false, new AsyncCallback.ChildrenCallback() {
            @Override
            public void processResult(int i, String s, Object o, List<String> list) {
                System.out.println(i);
                System.out.println(s);
                System.out.println(o);
                for (String l : list) {
                    System.out.println(l);
                }
            }
        }, "I am ctx");
    }

    @Test
    public void create13() throws Exception {
        Stat stat = zooKeeper.exists("/exists1", false);
        System.out.println(stat.getVersion());
    }

    @Test
    public void create14() throws Exception {
        zooKeeper.exists("/exists1", false, new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int i, String s, Object o, Stat stat) {
                System.out.println(i);
                System.out.println(s);
                System.out.println(o);
                System.out.println(stat.getVersion());
            }
        }, "I am ctx");
    }
}
