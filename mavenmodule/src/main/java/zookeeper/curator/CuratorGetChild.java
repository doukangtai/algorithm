package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/05/23
 */
public class CuratorGetChild {

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
        List<String> list = client.getChildren().forPath("/get");
        for (String r : list) {
            System.out.println(r);
        }
    }

    @Test
    public void create2() throws Exception {
        client.getChildren().inBackground((curatorFramework, curatorEvent) -> {
            System.out.println(curatorEvent.getPath());
            System.out.println(curatorEvent.getType());
            List<String> list = curatorEvent.getChildren();
            for (String l : list) {
                System.out.println(l);
            }
        }).forPath("/get");
    }
}
