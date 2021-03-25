package leetcode.greedy.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class JumpGameii {
    int[] memo;

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        memo = new int[nums.length];
        Arrays.fill(memo, nums.length);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (memo[i] != nums.length) {
            return memo[i];
        }
        for (int j = 1; j <= nums[i]; j++) {
            memo[i] = Math.min(memo[i], 1 + dp(nums, i + j));
        }
        return memo[i];
    }
}
