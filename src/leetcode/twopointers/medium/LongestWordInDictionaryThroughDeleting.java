package leetcode.twopointers.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/30
 */
public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord("abpcplea", new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"))));
    }

    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String dic : dictionary) {
            if (dic.length() < res.length() || (dic.length() == res.length() && res.compareTo(dic) < 0)) {
                continue;
            } else {
                if (isValid(s, dic)) {
                    res = dic;
                }
            }
        }
        return res;
    }

    private boolean isValid(String s, String dic) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < dic.length()) {
            if (s.charAt(i) == dic.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == dic.length();
    }
}
