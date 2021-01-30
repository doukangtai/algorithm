package leetcode.nSum.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/30
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, target);
    }

    public List<List<Integer>> nSum(int[] nums, int n, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 2) {
            int leftIndex = start;
            int rightIndex = nums.length - 1;
            while (leftIndex < rightIndex) {
                int leftVal = nums[leftIndex];
                int rightVal = nums[rightIndex];
                int sum = leftVal + rightVal;
                if (target == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(leftVal);
                    list.add(rightVal);
                    res.add(list);
                    while (leftIndex < rightIndex && nums[leftIndex] == leftVal) {
                        leftIndex++;
                    }
                    while (leftIndex < rightIndex && nums[rightIndex] == rightVal) {
                        rightIndex--;
                    }
                } else if (target < sum) {
                    rightIndex--;
                } else if (target > sum) {
                    leftIndex++;
                }
            }
        } else if (n > 2) {
            for (int i = start; i < nums.length; i++) {
                List<List<Integer>> tempList = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : tempList) {
                    list.add(nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
