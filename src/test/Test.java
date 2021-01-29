package test;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        int[] ints = new int[5];
        int num = 1;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = num;
        }
        num = 5;
        System.out.println(Arrays.toString(ints));
    }
}
