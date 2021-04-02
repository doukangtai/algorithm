package leetcode.dp.medium;

import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/02
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (String wd : wordDict) {
                if (wd.length() <= i && wd.equals(s.substring(i - wd.length(), i))) {
                    dp[i] = dp[i - wd.length()] || dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
