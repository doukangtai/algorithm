package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class Combinations {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().combine(4, 2));
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0) {
                return res;
            }
            help(1, n, k, res, new ArrayList<>());
            return res;
        }

        private void help(int s, int n, int k, List<List<Integer>> res, List<Integer> list) {
            if (list.size() == k) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = s; i <= n; i++) {
                list.add(i);
                help(i + 1, n, k, res, list);
                list.remove(list.size() - 1);
            }
        }
    }

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
