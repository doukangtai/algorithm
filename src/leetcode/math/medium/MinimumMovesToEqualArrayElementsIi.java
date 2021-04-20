package leetcode.math.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class MinimumMovesToEqualArrayElementsIi {
    public int minMoves2(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int res = 0;
        Arrays.sort(nums);
        while (p1 <= p2) {
            res += nums[p2--] - nums[p1++];
        }
        return res;
    }
}
