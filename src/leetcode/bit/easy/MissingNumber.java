package leetcode.bit.easy;

/**
 * @author 窦康泰
 * @date 2021/07/19
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ i ^ nums[i];
        }
        return res ^ nums.length;
    }
}
