package leetcode.dp.hard;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
