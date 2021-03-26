package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][][] dp = new int[piles.length][piles.length][2];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i][0] = piles[i];
        }
        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                int left = piles[i] + dp[i + 1][j][1];
                int right = piles[j] + dp[i][j - 1][1];
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }
        return dp[0][piles.length - 1][0] - dp[0][piles.length - 1][1] > 0;
    }
}
