package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/18
 */
public class CombinationSumIi {
    public static void main(String[] args) {
        System.out.println(new CombinationSumIi().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length <= 0) {
            return res;
        }
        Arrays.sort(candidates);
        help(candidates, target, new ArrayList<>(), res, 0, new boolean[candidates.length]);
        return res;
    }

    private void help(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int index, boolean[] isVisited) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            isVisited[i] = true;
            help(candidates, target - candidates[i], list, res, i + 1, isVisited);
            isVisited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
