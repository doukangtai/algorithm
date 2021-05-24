package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 窦康泰
 * @date 2021/05/23
 */
public class CuratorGet {

    String ips = "192.168.83.132:2181,192.168.83.132:2182,192.168.83.132:2183";
    CuratorFramework client;

    @Before
    public void before() {
        client = CuratorFrameworkFactory.builder()
                .connectString(ips)
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryOneTime(3000))
                .namespace("get")
                .build();
        client.start();
    }

    @After
    public void after() {
        client.close();
    }

    @Test
    public void create1() throws Exception {
        byte[] bytes = client.getData().forPath("/node1");
        System.out.println(new String(bytes));
    }

    @Test
    public void create2() throws Exception {
        Stat stat = new Stat();
        byte[] bytes = client.getData().storingStatIn(stat).forPath("/node1");
        System.out.println(stat.getVersion());
        System.out.println(new String(bytes));
    }

    @Test
    public void create3() throws Exception {
        client.getData().inBackground((curatorFramework, curatorEvent) -> {
            System.out.println(curatorEvent.getPath());
            System.out.println(curatorEvent.getType());
            System.out.println(new String(curatorEvent.getData()));
        }).forPath("/node1");
    }
}
