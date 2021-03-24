package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/24
 */
public class DeleteOperationForTwoStrings {
    public static void main(String[] args) {
        System.out.println(new DeleteOperationForTwoStrings().minDistance("sea", "eat"));
    }

    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }

    int[][] memo;

    public int lcs(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    private int dp(String word1, int i, String word2, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            memo[i][j] = 1 + dp(word1, i - 1, word2, j - 1);
        } else {
            memo[i][j] = Math.max(
                    dp(word1, i, word2, j - 1)
                    , dp(word1, i - 1, word2, j)
            );
        }
        return memo[i][j];
    }
}
