package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/07/18
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
