package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/03/24
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        String res = "";
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                String res1 = compute(s, i, i + 1);
                res = res.length() > res1.length() ? res : res1;
            }
            String res2 = compute(s, i, i);
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }

    public String compute(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
