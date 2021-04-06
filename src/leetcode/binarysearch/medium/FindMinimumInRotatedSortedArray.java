package leetcode.binarysearch.medium;

/**
 * @author 窦康泰
 * @date 2021/04/06
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int val = nums[right];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
