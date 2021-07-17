package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/07/17
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int missNum = 0, errorNum = 0;
        for (int i = 1; i <= nums.length; i++) {
            Integer count = map.get(i);
            if (count == null) {
                missNum = i;
            } else if (count == 2) {
                errorNum = i;
            }
        }
        return new int[]{errorNum, missNum};
    }
}
