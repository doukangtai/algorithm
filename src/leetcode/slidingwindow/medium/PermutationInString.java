package leetcode.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/01/25
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] s2Arr = s2.toCharArray();
        while (right < s2.length()) {
            char s2RightChar = s2Arr[right];
            right++;
            if (need.containsKey(s2RightChar)) {
                window.put(s2RightChar, window.getOrDefault(s2RightChar, 0) + 1);
                if (window.get(s2RightChar).equals(need.get(s2RightChar))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char s2LeftChar = s2Arr[left];
                left++;
                if (need.containsKey(s2LeftChar)) {
                    if (window.get(s2LeftChar).equals(need.get(s2LeftChar))) {
                        valid--;
                    }
                    window.put(s2LeftChar, window.get(s2LeftChar) - 1);
                }
            }
        }
        return false;
    }
}
