package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/04/03
 */
public class KeysKeyboard {
    public static void main(String[] args) {
        System.out.println(new KeysKeyboard().minSteps(3));
    }

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 2; j < n / 2 + 1; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }
}
