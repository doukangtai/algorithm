package leetcode.array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 窦康泰
 * @date 2021/07/18
 */
public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
            }
        }
        Set<Integer> keys = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (max == entry.getValue()) {
                keys.add(entry.getKey());
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer key : keys) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                if (key != nums[l]) {
                    l++;
                }
                if (key != nums[r]) {
                    r--;
                }
                if (key == nums[l] && key == nums[r]) {
                    break;
                }
            }
            int len = r - l + 1;
            res = Math.min(len, res);
        }
        return res;
    }
}
