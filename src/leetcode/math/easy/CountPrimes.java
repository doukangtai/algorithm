package leetcode.math.easy;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(10));
    }

    public int countPrimes(int n) {
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    flag[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (flag[i]) {
                count++;
            }
        }
        return count;
    }
}
