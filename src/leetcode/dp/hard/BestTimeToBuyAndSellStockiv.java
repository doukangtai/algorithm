package leetcode.dp.hard;

/**
 * @author 窦康泰
 * @date 2021/04/03
 */
public class BestTimeToBuyAndSellStockiv {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockiv().maxProfit(2, new int[]{2, 4, 1}));
    }

    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length + 1][k + 1][2];
        for (int i = 1; i < prices.length + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                if (i == 1) {
                    dp[i][j][1] = -prices[i - 1];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][k][0];
    }
}
