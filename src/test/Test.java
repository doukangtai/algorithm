package test;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        MH2();
    }

    public static void MH2() {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                4,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try {
            for (int i = 0; i < 8; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void MH1() {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    public static void MG1() {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println(queue.take());
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void TestMF4() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        new Thread(() -> {
            MF4(queue);
        }).start();
//        MF4(queue);
        new Thread(() -> {
            System.out.println("第1个 -> " + queue.poll());
            System.out.println("第2个 -> " + queue.poll());
            System.out.println("第3个 -> " + queue.poll());
            try {
                System.out.println("第4个 -> " + queue.poll(2, TimeUnit.SECONDS));
                System.out.println("第5个 -> " + queue.poll(3, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void MF4(ArrayBlockingQueue<Integer> queuep) {
        ArrayBlockingQueue<Integer> queue = queuep;
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
        try {
            System.out.println(queue.offer(4, 3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void MF3() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
//            queue.put(3);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void MF2() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));
//        System.out.println(queue.offer(3));
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
//        System.out.println(queue.poll());
    }

    public static void MF1() {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));
//        System.out.println(queue.add(3));
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
//        System.out.println(queue.remove());
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

class MyCache2 {
    private Map<Integer, Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void write() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                readWriteLock.writeLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " -> 线程开始写");
                    map.put(finalI, new Object());
                    System.out.println(Thread.currentThread().getName() + " -> 线程写完");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }).start();
        }
    }

    public void read() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                readWriteLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " -> 线程开始读");
                    map.get(finalI);
                    System.out.println(Thread.currentThread().getName() + " -> 线程读完");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.readLock().unlock();
                }
            }).start();
        }
    }
}

class MyCache1 {
    private Map<Integer, Object> map = new HashMap<>();

    public void write() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " -> 线程开始写");
                map.put(finalI, new Object());
                System.out.println(Thread.currentThread().getName() + " -> 线程写完");
            }).start();
        }
    }

    public void read() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " -> 线程开始读");
                map.get(finalI);
                System.out.println(Thread.currentThread().getName() + " -> 线程读完");
            }).start();
        }
    }
}
