package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/22
 */
public class Permutations {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().permute(new int[]{1, 2, 3}));
        }

        boolean[] visited;

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length <= 0) {
                return res;
            }
            visited = new boolean[nums.length];
            help(nums, res, new ArrayList<>());
            return res;
        }

        private void help(int[] nums, List<List<Integer>> res, List<Integer> list) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    list.add(nums[i]);
                    visited[i] = true;
                    help(nums, res, list);
                    visited[i] = false;
                    list.remove(Integer.valueOf(nums[i]));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permutations().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTracking(nums, track);
        return res;
    }

    public void backTracking(int[] nums, LinkedList<Integer> track) {
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!track.contains(nums[i])) {
                track.add(nums[i]);
                backTracking(nums, track);
                track.removeLast();
            }
        }
    }
}
