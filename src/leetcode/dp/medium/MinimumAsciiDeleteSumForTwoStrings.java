package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/24
 */
public class MinimumAsciiDeleteSumForTwoStrings {
    int[][] memo;

    public int minimumDeleteSum(String s1, String s2) {
        memo = new int[s1.length()][s2.length()];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return lcs(s1, 0, s2, 0);
    }

    private int lcs(String s1, int i, String s2, int j) {
        int res = 0;
        if (i == s1.length()) {
            while (j < s2.length()) {
                res += s2.charAt(j++);
            }
            return res;
        }
        if (j == s2.length()) {
            while (i < s1.length()) {
                res += s1.charAt(i++);
            }
            return res;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = lcs(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(
                    lcs(s1, i + 1, s2, j) + s1.charAt(i)
                    , lcs(s1, i, s2, j + 1) + s2.charAt(j)
            );
        }
        return memo[i][j];
    }
}
