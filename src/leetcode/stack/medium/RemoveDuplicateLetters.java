package leetcode.stack.medium;

import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2021/02/20
 */
public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        Stack<Character> res = new Stack<>();
        int[] count = new int[256];
        boolean[] isIn = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if (isIn[c]) {
                continue;
            }
            while (!res.isEmpty() && res.peek() > c) {
                if (count[res.peek()] == 0) {
                    break;
                }
                isIn[res.peek()] = false;
                res.pop();
            }
            res.push(c);
            isIn[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : res) {
            sb.append(c);
        }
        return sb.toString();
    }
}
