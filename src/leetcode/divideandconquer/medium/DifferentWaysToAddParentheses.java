package leetcode.divideandconquer.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/04/07
 */
public class DifferentWaysToAddParentheses {
    public static void main(String[] args) {
        System.out.println(new DifferentWaysToAddParentheses().diffWaysToCompute("2*3-4*5"));
    }

    Map<String, List<Integer>> mem = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        List<Integer> memRes = mem.get(expression);
        if (memRes != null) {
            return memRes;
        }
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        switch (c) {
                            case '+':
                                res.add(left.get(j) + right.get(k));
                                break;
                            case '-':
                                res.add(left.get(j) - right.get(k));
                                break;
                            case '*':
                                res.add(left.get(j) * right.get(k));
                                break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        mem.put(expression, res);
        return res;
    }
}
