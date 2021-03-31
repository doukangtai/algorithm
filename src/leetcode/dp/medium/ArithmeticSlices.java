package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/03/31
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[nums.length];
        if (nums[2] - nums[1] == nums[1] - nums[0]) {
            dp[2] = 1;
        }
        for (int i = 3; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int data : dp) {
            sum += data;
        }
        return sum;
    }
}
