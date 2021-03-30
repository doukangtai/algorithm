package leetcode.dp.easy;

/**
 * @author 窦康泰
 * @date 2021/03/30
 */
public class NumArray {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

    int[] nums;
    int[] dp;

    public NumArray(int[] nums) {
        this.nums = nums;
        dp = new int[nums.length];
        if (nums.length >= 1) {
            dp[0] = nums[0];
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left < 1) {
            return dp[right];
        }
        return dp[right] - dp[left - 1];
    }
}
