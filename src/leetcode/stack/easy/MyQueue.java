package leetcode.stack.easy;

import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2021/07/15
 */
public class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {}

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        help();
        return s2.pop();
    }

    public void help() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }

    public int peek() {
        help();
        return s2.peek();
    }

    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
    }
}
