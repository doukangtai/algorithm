package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/18
 */
public class SubsetsIi {
    public static void main(String[] args) {
        System.out.println(new SubsetsIi().subsetsWithDup(new int[]{1, 2, 2}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        help(nums, res, new ArrayList<>(), 0, new boolean[nums.length]);
        return res;
    }

    private void help(int[] nums, List<List<Integer>> res, List<Integer> list, int index, boolean[] isVisited) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            isVisited[i] = true;
            list.add(nums[i]);
            help(nums, res, list, i + 1, isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}
