package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class CoinChange {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().coinChange(new int[]{1, 2, 5}, 11));
        }

        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i < amount + 1; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i - coins[j] >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1, 2, 5}, 100));
    }

    /**
     * 法二：迭代
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                memo[i] = Math.min(memo[i], 1 + memo[i - coin]);
            }
        }
        return memo[amount] == amount + 1 ? -1 : memo[amount];
    }

//    /**
//     * 法一：递归
//     * @param coins
//     * @param amount
//     * @param memo
//     * @return
//     */
//    public int helper(int[] coins, int amount, int[] memo) {
//        if (amount == 0) {
//            return 0;
//        } else if (amount < 0) {
//            return -1;
//        }
//        if (memo[amount] != 0) {
//            return memo[amount];
//        }
//        int num = Integer.MAX_VALUE;
//        for (int i = 0; i < coins.length; i++) {
//            int nextVal = helper(coins, amount - coins[i], memo);
//            if (nextVal == -1) {
//                continue;
//            }
//            num = Math.min(num, 1 + nextVal);
//        }
//        memo[amount] = num == Integer.MAX_VALUE ? -1 : num;
//        return memo[amount];
//    }
//
//    public int coinChange(int[] coins, int amount) {
//        return helper(coins, amount, new int[amount + 1]);
//    }
}
