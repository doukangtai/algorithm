package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/04/02
 */
public class OnesAndZeroes {
    public static void main(String[] args) {
        System.out.println(new OnesAndZeroes().findMaxForm(new String[]{"10","0","1"}, 1, 1));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i < strs.length + 1; i++) {
            int zero = 0;
            int one = 0;
            for (int j = 0; j < strs[i - 1].length(); j++) {
                char c = strs[i - 1].charAt(j);
                if (c == '0') {
                    zero++;
                } else if (c == '1') {
                    one++;
                }
            }
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (j - zero >= 0 && k - one >= 0) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zero][k - one] + 1);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }
}
