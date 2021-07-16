package leetcode.str.easy;

/**
 * @author 窦康泰
 * @date 2021/07/16
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int curCount = 1;
        int preCount = 0;
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curCount++;
            } else {
                preCount = curCount;
                curCount = 1;
            }
            if (preCount >= curCount) {
                result++;
            }
        }
        return result;
    }
}
