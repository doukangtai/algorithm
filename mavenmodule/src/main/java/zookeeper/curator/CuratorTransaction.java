package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 窦康泰
 * @date 2021/05/23
 */
public class CuratorTransaction {

    String ips = "192.168.83.132:2181,192.168.83.132:2182,192.168.83.132:2183";
    CuratorFramework client;

    @Before
    public void before() {
        client = CuratorFrameworkFactory.builder()
                .connectString(ips)
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryOneTime(3000))
                .namespace("create")
                .build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void create1() throws Exception {
        client.inTransaction()
                .create()
                .forPath("/node1", "node1".getBytes())
                .and()
                .setData()
                .forPath("/node2", "node2".getBytes())
                .and()
                .commit();
    }

    @Test
    public void create2() throws Exception {
    }

    @Test
    public void create3() throws Exception {
    }

    @Test
    public void create4() throws Exception {
    }
}
