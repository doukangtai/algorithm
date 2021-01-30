package test;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        new Thread(() -> {
            threadLocal1.set(111);
            threadLocal2.set(222);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("AAA " + threadLocal1.get());
            System.out.println("AAA " + threadLocal2.get());
        }).start();
        new Thread(() -> {
            threadLocal1.set(1);
            threadLocal2.set(2);
            System.out.println("BBB " + threadLocal1.get());
            System.out.println("BBB " + threadLocal2.get());
        }).start();
        threadLocal1.remove();
        threadLocal2.remove();
    }
}

class ForkJoinExample extends RecursiveTask<Integer> {
    private int threshold = 5;
    private int first;
    private int last;

    public ForkJoinExample(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        if (last - first <= threshold) {
            int sum = 0;
            for (int i = first; i <= last; i++) {
                sum += i;
            }
            return sum;
        } else {
            int mid = first + (last - first) / 2;
            ForkJoinExample forkJoinExample1 = new ForkJoinExample(first, mid);
            ForkJoinExample forkJoinExample2 = new ForkJoinExample(mid + 1, last);
            ForkJoinTask<Integer> fork1 = forkJoinExample1.fork();
            ForkJoinTask<Integer> fork2 = forkJoinExample2.fork();
            return forkJoinExample1.join() + forkJoinExample2.join();
        }
    }
}
