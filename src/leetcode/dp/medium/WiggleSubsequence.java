package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/03/31
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int left = 1;
        int right = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                right = left + 1;
            } else if (nums[i] < nums[i - 1]) {
                left = right + 1;
            }
        }
        return Math.max(left, right);
    }
}
