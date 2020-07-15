package leetcode.stack;

import java.util.Stack;

/**
 * @author 窦康泰
 * @create 2020-07-15 20:34
 * https://leetcode-cn.com/problems/baseball-game/
 */
public class BaseballGame {

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                Integer temp = stack.pop();
                Integer peek = stack.peek();
                Integer sum = temp + peek;
                stack.push(temp);
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        Integer sum = 0;
        for (Integer flag : stack) {
            sum += flag;
        }
        return sum;
    }

}
