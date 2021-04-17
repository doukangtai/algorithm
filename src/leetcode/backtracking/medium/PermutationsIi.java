package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/17
 */
public class PermutationsIi {
    public static void main(String[] args) {
        System.out.println(new PermutationsIi().permuteUnique(new int[]{1, 1, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length <= 0) {
            return res;
        }
        Arrays.sort(nums);
        help(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void help(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] isVisited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            isVisited[i] = true;
            help(nums, res, list, isVisited);
            isVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
