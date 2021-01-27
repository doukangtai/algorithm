package leetcode.gupiaomaimaiwenti;

/**
 * @author 窦康泰
 * @date 2021/01/27
 */
public class BestTimeToBuyAndSellStockiii {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockiii()
                .maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= max_k; k++) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
