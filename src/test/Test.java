package test;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
//        ME1();
//        ME2();
        ME3();
    }

    public static void ME3() {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> before");
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> after");
                semaphore.release();
            }, String.valueOf(i)).start();
        }
    }

    public static void ME2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("CyclicBarrier执行了");
        });
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void ME1() {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ME1");
    }

    public static void MD1() {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("call方法输出");
                Thread.sleep(1000);
                return "call被调用了";
            }
        });
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        new Thread(futureTask).start();
        String s = null;
        try {
            s = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("返回值： " + s);
    }

    public static void MC2() {
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            new Thread(() -> {
                map.put(String.valueOf(num), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + " -> " + map);
            }).start();
        }
    }

    public static void MC1() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int num = i + 1;
            new Thread(() -> {
                map.put(String.valueOf(num), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }).start();
        }
    }

    public static void MB3() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + " -> " + set);
            }).start();
        }
    }

    public static void MB2() {
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + " -> " + set);
            }).start();
        }
    }

    public static void MB1() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(Thread.currentThread().getName() + " -> " + set);
            }).start();
        }
    }

    public static void MA4() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }

    public static void MA3() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }

    public static void MA2() {
        List<String> list = new Vector<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }

    public static void MA1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }
}
