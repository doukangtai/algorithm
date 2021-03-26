package leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        help(n, n, new StringBuilder());
        return res;
    }

    public void help(int left, int right, StringBuilder sb) {
        if (left < 0 || right < 0) {
            return;
        }
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }

        sb.append('(');
        help(left - 1, right, sb);
        sb.delete(sb.length() - 1, sb.length());

        sb.append(')');
        help(left, right - 1, sb);
        sb.delete(sb.length() - 1, sb.length());
    }
}
