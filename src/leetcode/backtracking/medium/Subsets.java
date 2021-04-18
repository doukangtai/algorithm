package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class Subsets {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().subsets(new int[]{1, 2, 3}));
        }

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            help(nums, new ArrayList<>(), res, 0);
            return res;
        }

        private void help(int[] nums, List<Integer> list, List<List<Integer>> res, int index) {
            res.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                help(nums, list, res, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>());
        return res;
    }

    public void backTrack(int[] nums, int start, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
