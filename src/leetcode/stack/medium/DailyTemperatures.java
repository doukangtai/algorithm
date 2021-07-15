package leetcode.stack.medium;

import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2021/07/15
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> indexs = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int cur = 0; cur < temperatures.length; cur++) {
            while (!indexs.isEmpty() && temperatures[cur] > temperatures[indexs.peek()]) {
                Integer preIndex = indexs.pop();
                result[preIndex] = cur - preIndex;
            }
            indexs.push(cur);
        }
        return result;
    }
}
