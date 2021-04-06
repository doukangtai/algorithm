package leetcode.binarysearch.medium;

/**
 * @author 窦康泰
 * @date 2021/04/06
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int pre = 0;
        int next = 1;
        while (next < nums.length) {
            if (nums[pre] == nums[next]) {
                pre += 2;
                next += 2;
            } else {
                break;
            }
        }
        return nums[pre];
    }
}
