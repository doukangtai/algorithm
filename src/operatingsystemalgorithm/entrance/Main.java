package operatingsystemalgorithm.entrance;

import operatingsystemalgorithm.themefour.clock.Clock;
import operatingsystemalgorithm.themefour.lru.LeastRecentlyUsed;
import operatingsystemalgorithm.themefour.opt.OptimalReplacementAlgorithm;
import operatingsystemalgorithm.themetwo.roundrobin.RoundRobinAlgorithm;

import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2020/10/25
 */
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("2.时间片轮转调度算法");
            System.out.println("41.Optimal页面置换算法");
            System.out.println("42.LRU页面置换算法");
            System.out.println("43.Clock页面置换算法");
            System.out.print("输入序号选择要使用的算法:");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            switch (num) {
                case 2:
                    RoundRobinAlgorithm.start();
                    System.out.println();
                    break;
                case 41:
                    OptimalReplacementAlgorithm.start();
                    System.out.println();
                    break;
                case 42:
                    LeastRecentlyUsed.start();
                    System.out.println();
                    break;
                case 43:
                    Clock.start();
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }
}
