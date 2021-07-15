package leetcode.stack.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 窦康泰
 * @date 2021/07/15
 */
public class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public MyStack() {}

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        while (size-- > 0) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
