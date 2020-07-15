package leetcode.stack;

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

}
