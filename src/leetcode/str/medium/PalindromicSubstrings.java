package leetcode.str.medium;

/**
 * @author 窦康泰
 * @date 2021/07/16
 */
public class PalindromicSubstrings {
    private int result;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstrings(s, i, i);
            extendSubstrings(s, i, i + 1);
        }
        return result;
    }

    private void extendSubstrings(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            result++;
            l--;
            r++;
        }
    }
}
