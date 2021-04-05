package leetcode.greedy.easy;

/**
 * @author 窦康泰
 * @date 2021/04/05
 */
public class IsSubsequence {
    static class Method2 {
        public boolean isSubsequence(String s, String t) {
            int p1 = 0;
            int p2 = 0;
            while (p1 < s.length() && p2 < t.length()) {
                if (s.charAt(p1) == t.charAt(p2)) {
                    p1++;
                }
                p2++;
            }
            if (p1 == s.length()) {
                return true;
            }
            return false;
        }
    }

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
