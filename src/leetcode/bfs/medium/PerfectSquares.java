package leetcode.bfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/09
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i - list.get(j) >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - list.get(j)] + 1);
                }
            }
        }
        return dp[n];
    }
}
