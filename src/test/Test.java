package test;

import test.pac.Test1;

import java.util.Date;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        Test2 test2 = new Test2();
//        System.out.println(test1.a);
//        System.out.println(test1.method());
        new Thread(() -> {
            synchronized (test1) {
                try {
                    test1.wait();
                    System.out.println("111");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            synchronized (test1) {
                try {
                    test1.wait();
                    System.out.println("222");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (test1) {
            test1.notify();
        }
        synchronized (test2) {
            test2.notify();
        }
    }
}

class Test2 extends Test1 {
    protected void m() {
        System.out.println(a + "=====");
        System.out.println(method() + "===");
    }
}

//class Test1 {
//    protected int a = 18;
//
//    protected int method() {
//        return a;
//    }
//}

class Person implements Cloneable {
    Date date;

    int age;

    Student student;

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
//        clone.date = (Date) clone.date.clone();
//        clone.student = (Student) clone.student.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "date=" + date +
                ", age=" + age +
                ", student=" + student +
                '}';
    }
}

class Student implements Cloneable {
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

