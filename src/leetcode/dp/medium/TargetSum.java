package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/02/21
 */
public class TargetSum {
    private int res;

    public int findTargetSumWays(int[] nums, int S) {
        help(nums, S, 0);
        return res;
    }

    public void help(int[] nums, int S, int index) {
        if (index == nums.length) {
            if (S == 0) {
                res++;
            }
            return;
        }
        S -= nums[index];
        help(nums, S, index + 1);
        S += nums[index];
        S += nums[index];
        help(nums, S, index + 1);
        S -= nums[index];
    }
}
