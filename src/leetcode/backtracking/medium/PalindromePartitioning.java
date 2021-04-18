package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/18
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        help(s, new ArrayList<>(), res);
        return res;
    }

    private void help(String s, List<String> list, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(0, i + 1);
            if (valid(subStr)) {
                list.add(subStr);
                help(s.substring(i + 1), list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean valid(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
