package leetcode.math.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class EatGrape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            System.out.println(compute(a, b, c));
        }
    }

    public static long compute(long a, long b, long c) {
        long[] arr = {a, b, c};
        Arrays.sort(arr);
        if (arr[0] + arr[1] > arr[2]) {
            return (arr[0] + arr[1] + arr[2] + 2) / 3;
        }
        if ((arr[0] + arr[1]) * 2 < arr[2]) {
            return (arr[2] + 1) / 2;
        }
        return (arr[0] + arr[1] + arr[2] + 2) / 3;
    }
}
