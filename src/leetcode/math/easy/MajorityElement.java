package leetcode.math.easy;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
