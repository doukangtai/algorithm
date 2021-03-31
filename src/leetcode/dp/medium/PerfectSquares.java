package leetcode.dp.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/31
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }

    public int numSquares(int n) {
        List<Integer> col = new ArrayList<>();
        for (int i = 1;; i++) {
            int num = i * i;
            if (num <= n) {
                col.add(i * i);
            } else {
                break;
            }
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < col.size() && col.get(j) <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - col.get(j)] + 1);
            }
        }
        return dp[n];
    }
}
