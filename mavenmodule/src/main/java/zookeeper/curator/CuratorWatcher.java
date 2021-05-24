package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryOneTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 窦康泰
 * @date 2021/05/23
 */
public class CuratorWatcher {

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
        NodeCache nodeCache = new NodeCache(client, "/watcher1");
        nodeCache.start();
        nodeCache.getListenable().addListener(() -> {
            System.out.println(nodeCache.getCurrentData().getPath());
            System.out.println(new String(nodeCache.getCurrentData().getData()));
        });
        Thread.sleep(100000);
        nodeCache.close();
    }

    @Test
    public void create2() throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/watcher1", true);
        pathChildrenCache.start();
        pathChildrenCache.getListenable().addListener((curatorFramework, pathChildrenCacheEvent) -> {
            System.out.println(pathChildrenCacheEvent.getData().getPath());
            System.out.println(pathChildrenCacheEvent.getType());
            System.out.println(new String(pathChildrenCacheEvent.getData().getData()));
        });
        Thread.sleep(100000);
        pathChildrenCache.close();
    }

    @Test
    public void create3() throws Exception {
    }

    @Test
    public void create4() throws Exception {
    }
}
