package leetcode.stack.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 窦康泰
 * @create 2020-07-15 17:13
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParenthesis {

    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hashMap.containsKey(c)) {
                Character ch = stack.isEmpty() ? '*' : stack.pop();
                if (!ch.equals(hashMap.get(c))) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().isValid("()[]}"));
    }

    static class Method2 {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    Character popChar = stack.pop();
                    if ((popChar == '(' && c == ')') || (popChar == '{' && c == '}') || (popChar == '[' && c == ']')) {
                    } else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
