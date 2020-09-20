package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 10:14
 */
public class Test implements Comparable<Test> {

    private int num;

    public Test() {
        this(3);
    }

    public Test(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Test{" +
                "num=" + num +
                '}';
    }

    @Override
    public int compareTo(Test o) {
        return this.num - o.num;
    }
}

class Test2 {

    public static void main(String[] args) {
        List<Test> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(new Test(i));
        }
        Collections.shuffle(list);
//        list.stream().forEach(System.out::println);
//        Collections.sort(list);
        Collections.sort(list, new MyComparator());
        for (Test test : list) {
            System.out.println(test);
        }
        Test test = new Test();
        System.out.println(test.getNum());
    }

}

class MyComparator implements Comparator<Test> {

    @Override
    public int compare(Test o1, Test o2) {
        return o2.getNum() - o1.getNum();
    }
}
