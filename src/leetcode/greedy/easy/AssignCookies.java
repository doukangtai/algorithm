package leetcode.greedy.easy;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/04/04
 */
public class AssignCookies {
    public static void main(String[] args) {
        System.out.println(new AssignCookies().findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLen = 0;
        int sLen = 0;
        while (gLen < g.length && sLen < s.length) {
            if (g[gLen] <= s[sLen]) {
                gLen++;
            }
            sLen++;
        }
        return gLen;
    }
}
