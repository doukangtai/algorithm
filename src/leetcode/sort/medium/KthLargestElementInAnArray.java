package leetcode.sort.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/04
 */
public class KthLargestElementInAnArray {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }

        public int findKthLargest(int[] nums, int k) {
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                heap(nums, i, nums.length);
            }
            swap(nums, 0, nums.length - 1);
            int len = nums.length - 1;
            while (len > 0) {
                heap(nums, 0, len);
                swap(nums, 0, len - 1);
                len--;
            }
            return nums[nums.length - k];
        }

        private void heap(int[] nums, int i, int length) {
            int max = i;
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (left < length && nums[left] > nums[max]) {
                max = left;
            }
            if (right < length && nums[right] > nums[max]) {
                max = right;
            }
            if (max != i) {
                swap(nums, i, max);
                heap(nums, max, length);
            }
        }

        private void swap(int[] nums, int i, int max) {
            int temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
        }
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
