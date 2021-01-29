package leetcode.nSum.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/29
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            twoSum(nums, num, 0, i + 1);
            while (i <= nums.length - 2 && num == nums[i + 1]) {
                i++;
            }
        }
        return lists;
    }

    public void twoSum(int[] nums, int num, int target, int start) {
        int targetSum = target - num;
        int leftIndex = start;
        int rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int left = nums[leftIndex];
            int right = nums[rightIndex];
            int tempSum = left + right;
            if (targetSum > tempSum) {
                leftIndex++;
            } else if (targetSum < tempSum) {
                rightIndex--;
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(num);
                l.add(left);
                l.add(right);
                lists.add(l);
                while (leftIndex < rightIndex && left == nums[leftIndex]) {
                    leftIndex++;
                }
                while (leftIndex < rightIndex && right == nums[rightIndex]) {
                    rightIndex--;
                }
            }
        }
    }
}
