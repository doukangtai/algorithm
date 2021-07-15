package leetcode.hashtable.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 窦康泰
 * @date 2021/07/15
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int result = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int tempLen = 1;
                while (set.contains(curNum + 1)) {
                    curNum++;
                    tempLen++;
                }
                result = Math.max(result, tempLen);
            }
        }
        return result;
    }
}
