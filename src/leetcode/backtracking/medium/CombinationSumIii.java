package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/18
 */
public class CombinationSumIii {
    public static void main(String[] args) {
        System.out.println(new CombinationSumIii().combinationSum3(3, 9));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        help(k, n, new ArrayList<>(), res, 1);
        return res;
    }

    private void help(int k, int n, List<Integer> list, List<List<Integer>> res, int index) {
        if (n < 0 || list.size() > k) {
            return;
        }
        if (n == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= 9; i++) {
            list.add(i);
            help(k, n - i, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
