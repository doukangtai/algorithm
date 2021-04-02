package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/04/02
 */
public class CombinationSumIv {
    public static void main(String[] args) {
        System.out.println(new CombinationSumIv().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}
