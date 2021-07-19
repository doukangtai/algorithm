package leetcode.bit.easy;

/**
 * @author 窦康泰
 * @date 2021/07/19
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
