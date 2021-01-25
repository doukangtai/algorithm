package leetcode.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/01/25
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("abc", "bc"));
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] sArr = s.toCharArray();
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char sRightChar = sArr[right];
            right++;
            if (need.containsKey(sRightChar)) {
                window.put(sRightChar, window.getOrDefault(sRightChar, 0) + 1);
                if (window.get(sRightChar).equals(need.get(sRightChar))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (len > right - left) {
                    start = left;
                    len = right - left;
                }
                char sLeftChar = sArr[left];
                left++;
                if (need.containsKey(sLeftChar)) {
                    if (window.get(sLeftChar).equals(need.get(sLeftChar))) {
                        valid--;
                    }
                    window.put(sLeftChar, window.get(sLeftChar) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
