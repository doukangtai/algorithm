package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class CoinChange2 {
    static class Method3 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int i = 1; i < coins.length + 1; i++) {
                for (int j = 1; j < amount + 1; j++) {
                    if (j - coins[i - 1] >= 0) {
                        dp[j] += dp[j - coins[i - 1]];
                    }
                }
            }
            return dp[amount];
        }
    }

    static class Method2 {
        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length + 1][amount + 1];
            for (int i = 0; i < coins.length + 1; i++) {
                dp[i][0] = 1;
            }
            for (int i = 1; i < coins.length + 1; i++) {
                for (int j = 1; j < amount + 1; j++) {
                    for (int k = 0; j - k * coins[i - 1] >= 0; k++) {
                        dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[]{1, 2, 5}));
    }

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < coins.length + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < coins.length + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                for (int k = 0; j - k * coins[i - 1] >= 0; k++) {
                    dp[i][j] += dp[i - 1][j - k * coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }
}
