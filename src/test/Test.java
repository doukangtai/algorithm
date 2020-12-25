package test;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 10:14
 */
public class Test {

    public static void main(String[] args) {
        new cl().clm1();
        it.m2();
    }
}

class cl implements it {
    void clm1() {
        m1();
    }
}

interface it {
    default void m1() {
        System.out.println("it---m1");
    }

    static void m2() {
        System.out.println("static---m2");
    }
}
