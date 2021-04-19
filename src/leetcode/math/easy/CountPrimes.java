package leetcode.math.easy;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class CountPrimes {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().countPrimes(10));
        }

        public int countPrimes(int n) {
            int res = 0;
            boolean[] isPr = new boolean[n];
            Arrays.fill(isPr, true);
            for (int i = 2; i < n; i++) {
                if (isPr[i]) {
                    res++;
                    for (int j = i * 2; j < n; j += i) {
                        isPr[j] = false;
                    }
                }
            }
            return res;
        }
    }

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
