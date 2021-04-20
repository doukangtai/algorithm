package leetcode.math.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            left *= nums[i - 1];
            res[i] *= left;
        }
        int right = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
