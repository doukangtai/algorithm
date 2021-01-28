package test;

import java.util.concurrent.TimeUnit;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(() -> {
            synchronized (lockA) {
                try {
                    System.out.println(Thread.currentThread().getName() + "获取" + lockA);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "获取" + lockB);
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (lockB) {
                try {
                    System.out.println(Thread.currentThread().getName() + "获取" + lockB);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println(Thread.currentThread().getName() + "获取" + lockA);
                }
            }
        }).start();
    }
}
