package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class Combinations {
    public static void main(String[] args) {
        System.out.println(new Combinations().combine(4, 2));
    }

    List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        help(1, n, k, new ArrayList<>());
        return res;
    }

    public void help(int start, int n, int k, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            help(i + 1, n, k, list);
            list.remove(list.size() - 1);
        }
    }
}
