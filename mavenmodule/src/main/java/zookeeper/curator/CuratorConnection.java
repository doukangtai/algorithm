package zookeeper.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;

/**
 * @author 窦康泰
 * @date 2021/05/23
 */
public class CuratorConnection {
    public static void main(String[] args) {
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString("192.168.83.132:2181,192.168.83.132:2182,192.168.83.132:2183")
                .sessionTimeoutMs(5000)
                .retryPolicy(new RetryOneTime(3000))
                .namespace("create")
                .build();
        client.start();
        System.out.println(client.isStarted());
        client.close();
    }
}
