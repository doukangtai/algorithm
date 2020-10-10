package learn.kmp;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/10/09
 */
public class KMP {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
//        String str2 = "ABCDABD";
        String str2 = "ABCDXXABCXXAB";
        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(str1, str2, next);
        System.out.println(index);
    }

    /**
     * 获取next数组，next数组中的值对应前缀与后缀最长匹配值
     * @param str2
     * @return
     */
    public static int[] kmpNext(String str2) {
        int[] next = new int[str2.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < str2.length(); i++) {
            // 不相等时，注意将j迁移
            while (j > 0 && str2.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            // 相等同时后移，并记录进next数组中
            if (str2.charAt(i) == str2.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    /**
     * kmp算法
     * @param str1
     * @param str2
     * @param next
     * @return
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i = 0, j = 0; i < str1.length(); i++) {
            // 注意在不匹配时通过next数组将j前移
            while (j > 0 && str1.charAt(i) != str2.charAt(j)) {
                j = next[j - 1];
            }
            // 相等同时后移
            if (str1.charAt(i) == str2.charAt(j)) {
                j++;
            }
            // 匹配完成返回index
            if (j == str2.length()) {
                return i - (j - 1);
            }
        }
        return -1;
    }

}
