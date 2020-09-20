package test;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 15:16
 */
public class Test22 {

    int id = 1;

    public void t() {
        System.out.println("t1");
    }

    public static void main(String[] args) {
        Test22 test22 = new Son();
        System.out.println(test22.id);
        test22.t();
    }

}

class Son extends Test22 {

    int id = 2;

    @Override
    public void t() {
        System.out.println("t2");
    }

}
