package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和  https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {

    /**
     * 利用哈希表，边存储，边比较
     * 时间复杂度O(n)    空间复杂度O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int flag = target - nums[i];
            if (map.containsKey(flag) && map.get(flag) != i) {
                return new int[]{map.get(flag), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("不存在");
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(new int[]{1, 2, 3, 4, 5}, 8);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
