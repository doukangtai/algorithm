package leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 窦康泰
 * @date 2020/10/14
 */
public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);
    }

//    Deque<Integer> queue = null;
//
//    /** Initialize your data structure here. */
//    public ImplementStackUsingQueues() {
//        queue = new LinkedList<>();
//    }
//
//    /** Push element x onto stack. */
//    public void push(int x) {
//        queue.push(x);
//    }
//
//    /** Removes the element on top of the stack and returns that element. */
//    public int pop() {
//        return queue.pop();
//    }
//
//    /** Get the top element. */
//    public int top() {
//        return queue.peek();
//    }
//
//    /** Returns whether the stack is empty. */
//    public boolean empty() {
//        return queue.isEmpty();
//    }

    Queue<Integer> queue1 = null;
    Queue<Integer> queue2 = null;

    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
