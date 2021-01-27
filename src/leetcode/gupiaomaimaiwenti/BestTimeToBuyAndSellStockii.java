package leetcode.gupiaomaimaiwenti;

/**
 * @author 窦康泰
 * @date 2021/01/27
 */
public class BestTimeToBuyAndSellStockii {
    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuyAndSellStockii().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 <= -1) {
                dp[i][0] = 0;
                dp[i][1] = - prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
