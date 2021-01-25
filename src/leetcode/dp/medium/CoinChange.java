package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class CoinChange {
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
