package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/14
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations(""));
    }

    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() <= 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        help(res, digits, new StringBuilder());
        return res;
    }

    private void help(List<String> res, String digits, StringBuilder sb) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String s = map[digits.charAt(sb.length()) - '0'];
        for (char c : s.toCharArray()) {
            sb.append(c);
            help(res, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
