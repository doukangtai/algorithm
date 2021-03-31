package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/03/31
 */
public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("27"));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if (s.charAt(0) == '0') {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            if (s.charAt(i - 1) == '0') {
                if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2') {
                    dp[i] = dp[i - 2];
                } else {
                    return 0;
                }
            } else {
                if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '1' && s.charAt(i - 1) <= '6')) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }
}
