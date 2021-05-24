package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.RetryOneTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 窦康泰
 * @date 2021/05/23
 */
public class CuratorLock {

    String ips = "192.168.83.132:2181,192.168.83.132:2182,192.168.83.132:2183";
    CuratorFramework client;

    @Before
    public void before() {
        client = CuratorFrameworkFactory.builder()
                .connectString(ips)
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryOneTime(3000))
                .build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void create1() throws Exception {
        InterProcessLock lock = new InterProcessMutex(client, "/lock1");
        System.out.println("等待获取锁对象");
        lock.acquire();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        lock.release();
        System.out.println("等待释放锁！");
    }

    @Test
    public void create2() throws Exception {
        InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(client, "/lock1");
        InterProcessMutex lock = readWriteLock.readLock();
        System.out.println("等待获取锁对象");
        lock.acquire();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        lock.release();
        System.out.println("等待释放锁！");
    }

    @Test
    public void create3() throws Exception {
        InterProcessReadWriteLock readWriteLock = new InterProcessReadWriteLock(client, "/lock1");
        InterProcessMutex lock = readWriteLock.writeLock();
        System.out.println("等待获取锁对象");
        lock.acquire();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        lock.release();
        System.out.println("等待释放锁！");
    }

    @Test
    public void create4() throws Exception {
    }
}
