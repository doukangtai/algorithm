package leetcode.twopointers.easy;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        System.out.println(new ImplementStrstr().strStr("", ""));
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        KMP(needle);
        return search(haystack);
    }

    int[][] dp;

    public void KMP(String pat) {
        dp = new int[pat.length()][128];
        dp[0][pat.charAt(0)] = 1;
        int memo = 0;
        for (int i = 1; i < pat.length(); i++) {
            for (int j = 0; j < 128; j++) {
                if (pat.charAt(i) == j) {
                    dp[i][pat.charAt(i)] = i + 1;
                } else {
                    dp[i][j] = dp[memo][j];
                }
            }
            memo = dp[memo][pat.charAt(i)];
        }
    }

    public int search(String str) {
        int next = 0;
        for (int i = 0; i < str.length(); i++) {
            next = dp[next][str.charAt(i)];
            if (next == dp.length) {
                return i - next + 1;
            }
        }
        return -1;
    }
}
