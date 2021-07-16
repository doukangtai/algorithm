package leetcode.str.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/07/16
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("ccc"));
    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result += entry.getValue();
            } else {
                result += entry.getValue() - entry.getValue() % 2;
                count++;
            }
        }
        result += count > 0 ? 1 : 0;
        return result;
    }
}
