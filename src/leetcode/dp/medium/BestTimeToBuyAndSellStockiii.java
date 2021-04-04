package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/04/03
 */
public class BestTimeToBuyAndSellStockiii {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockiii().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }

    public int maxProfit(int[] prices) {
        int times = 2;
        int[][][] dp = new int[prices.length + 1][times + 1][2];
        for (int i = 1; i < prices.length + 1; i++) {
            for (int j = 1; j < times + 1; j++) {
                if (i == 1) {
                    dp[i][j][1] = -prices[i - 1];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][2][0];
    }
}
