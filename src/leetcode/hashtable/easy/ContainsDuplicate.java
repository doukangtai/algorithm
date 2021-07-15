package leetcode.hashtable.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/07/15
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Object> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, null);
            }
        }
        return false;
    }
}
