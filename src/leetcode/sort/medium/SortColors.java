package leetcode.sort.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/04
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {1, 2, 0};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int zero = -1;
        int one = 0;
        int two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, one++, ++zero);
            } else if (nums[one] == 1) {
                one++;
            } else if (nums[one] == 2) {
                swap(nums, one, --two);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
