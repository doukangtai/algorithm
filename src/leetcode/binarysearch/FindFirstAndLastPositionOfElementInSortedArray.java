package leetcode.binarysearch;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/24
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray searchRange = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] range = searchRange.searchRange(new int[]{1, 2, 2, 2, 3}, 12);
        System.out.println(Arrays.toString(range));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeftBound(nums, target), searchRightBound(nums, target)};
    }

    public int searchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    public int searchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }
}
