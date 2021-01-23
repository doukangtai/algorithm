package test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
//        M1();
//        M2();
//        M3();
        M4();
    }

    public static void M4() {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }

    public static void M3() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }

    public static void M2() {
        List<String> list = new Vector<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }

    public static void M1() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(new String(UUID.randomUUID().toString().substring(0, 5)));
                System.out.println(list);
            }).start();
        }
    }
}
