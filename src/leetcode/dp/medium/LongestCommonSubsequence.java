package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/24
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
    }

    int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return dp(text1, 0, text2, 0);
    }

    public int dp(String text1, int i, String text2, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + dp(text1, i + 1, text2, j + 1);
        } else {
            memo[i][j] = Math.max(
                    dp(text1, i, text2, j + 1)
                    , dp(text1, i + 1, text2, j)
            );
        }
        return memo[i][j];
    }

    static class Method2 {
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] dp = new int[text1.length() + 1][text2.length() + 1];
            for (int i = 1; i <= text1.length(); i++) {
                for (int j = 1; j <= text2.length(); j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}
