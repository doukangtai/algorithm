package leetcode.dp.hard;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class SuperEggDrop {
    public static void main(String[] args) {
        System.out.println(new SuperEggDrop().superEggDrop(2, 300));
    }

    static class Method2 {
        public int superEggDrop(int k, int n) {
            int[][] dp = new int[k + 1][n + 1];
            int res = 0;
            while (dp[k][res] < n) {
                res++;
                for (int i = 1; i <= k; i++) {
                    dp[i][res] = dp[i][res - 1] + dp[i - 1][res - 1] + 1;
                }
            }
            return res;
        }
    }

    int[][] memo;

    public int superEggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        for (int[] me : memo) {
            Arrays.fill(me, Integer.MAX_VALUE);
        }
        return dp(k, n);
    }

    public int dp(int k, int n) {
        if (k == 1) {
            return n;
        }
        if (n == 0) {
            return 0;
        }
        if (memo[k][n] != Integer.MAX_VALUE) {
            return memo[k][n];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            res = Math.min(
                    res,
                    1 + Math.max(
                            dp(k, n - i),
                            dp(k - 1, i - 1)
                    )
            );
        }
        memo[k][n] = res;
        return res;
    }
}
