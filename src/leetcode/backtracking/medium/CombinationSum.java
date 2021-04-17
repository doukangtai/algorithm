package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/17
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return res;
        }
        help(candidates, target, new ArrayList<>(), res, 0, 0);
        return res;
    }

    private void help(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum += candidates[i];
            list.add(candidates[i]);
            help(candidates, target, list, res, sum, i);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
