package template.sort;

import java.util.Arrays;

/**
 * @Author 窦康泰
 * @Date 2020-07-20 11:57
 */
public class Knapsack {

    public static void main(String[] args) {
        // 物品数量
        int N = 5;
        // 背包容量
        int C = 10;
        // 物品容量
        int[] v = {1, 2, 3, 4, 5};
        // 物品重量
        int[] w = {5, 4, 3, 2, 1};
        int[][] dp = new int[N + 1][C + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, 0);
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (j >= v[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i - 1]] + w[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][C]);
    }

}
