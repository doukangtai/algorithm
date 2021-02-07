package test;

import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class Test {
    public static void main(String[] args) {
        String str = new String("abc");
        String intern = str.intern();
        String s = "abc";
        System.out.println(str == s);
        System.out.println(s == intern);
        new Scanner(System.in).next();
    }
}
