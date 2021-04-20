package leetcode.math.easy;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n3 = nums.length - 1;
        int n2 = nums.length - 2;
        int n1 = nums.length - 3;
        int r1 = nums[n1] * nums[n2] * nums[n3];
        int r2 = nums[0] * nums[1] * nums[n3];
        return Math.max(r1, r2);
    }
}
