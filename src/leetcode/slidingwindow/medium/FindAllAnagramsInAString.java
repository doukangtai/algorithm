package leetcode.slidingwindow.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/01/25
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().
                findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> targetList = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] sArr = s.toCharArray();
        while (right < s.length()) {
            char sRightChar = sArr[right];
            right++;
            if (need.containsKey(sRightChar)) {
                window.put(sRightChar, window.getOrDefault(sRightChar, 0) + 1);
                if (window.get(sRightChar).equals(need.get(sRightChar))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    targetList.add(left);
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
        return targetList;
    }
}
