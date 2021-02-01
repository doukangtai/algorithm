package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new Person(new Random().nextInt(1024 * 1024)));
        }
    }
}

class Person {
    byte[] bytes;

    public Person(int i) {
        this.bytes = new byte[i];
    }
}
