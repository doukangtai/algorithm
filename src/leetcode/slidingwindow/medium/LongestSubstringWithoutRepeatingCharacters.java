package leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/01/25
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        char[] sArr = s.toCharArray();
        while (right < s.length()) {
            char sRightChar = sArr[right];
            right++;
            window.put(sRightChar, window.getOrDefault(sRightChar, 0) + 1);
            while (window.get(sRightChar) > 1) {
                char sLeftChar = sArr[left];
                left++;
                window.put(sLeftChar, window.get(sLeftChar) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
