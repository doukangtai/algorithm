package leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 窦康泰
 * @date 2020/10/14
 */
public class MinStack {

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
//        deque.add(1);
//        deque.add(2);
//        deque.add(3);
//        deque.add(4);
//        deque.add(5);
//        System.out.println(deque);
        deque.push(1);
        deque.push(2);
        deque.push(3);
        deque.push(4);
        deque.push(5);
//        System.out.println(deque.pop());
//        System.out.println(deque.pop());
        System.out.println(deque);
//        for (Integer integer : deque) {
//            System.out.println(integer);
//        }
//        System.out.println(deque);
//        deque.add(10);
//        System.out.println(deque);
//        System.out.println(deque.peek());
//        System.out.println(deque);
    }

//    Stack<Integer> stack = null;
//
//    public MinStack() {
//        stack = new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//    }
//
//    public void pop() {
//        stack.pop();
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        int min = Integer.MAX_VALUE;
//        for (Integer integer : stack) {
//            if (integer < min) {
//                min = integer;
//            }
//        }
//        return min;
//    }

    /**
     * 题解
     */
    Deque<Integer> stack = null;
    Deque<Integer> minStack = null;

    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
