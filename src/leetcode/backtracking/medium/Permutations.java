package leetcode.backtracking.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/22
 */
public class Permutations {
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
