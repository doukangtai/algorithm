package test;

/**
 * @Author 窦康泰
 * @Date 2020-08-21 10:14
 */
public class Test {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
//        System.out.println(MAXIMUM_CAPACITY);
        int cap = 9;
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int temp = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(temp);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}

