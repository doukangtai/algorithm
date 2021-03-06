package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/04/03
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[1][1] = -prices[0];
        for (int i = 2; i < prices.length + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }
}
