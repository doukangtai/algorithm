package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/28
 */
public class HouseRobberii {
    public static void main(String[] args) {
        System.out.println(new HouseRobberii().rob(new int[]{1, 2, 1, 1}));
    }

    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int dp1 = dp(nums, 0, nums.length - 2);
        Arrays.fill(memo, -1);
        int dp2 = dp(nums, 1, nums.length - 1);
        return Math.max(dp1, dp2);
    }

    public int dp(int[] nums, int start, int end) {
        if (nums.length <= 1) {
            return nums[0];
        }
        if (start > end) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(nums[start] + dp(nums, start + 2, end), dp(nums, start + 1, end));
        memo[start] = res;
        return res;
    }
}
