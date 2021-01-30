package leetcode.gupiaomaimaiwenti.medium;

/**
 * @author 窦康泰
 * @date 2021/01/27
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee()
                .maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
