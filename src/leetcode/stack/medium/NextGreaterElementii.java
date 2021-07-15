package leetcode.stack.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2021/07/15
 */
public class NextGreaterElementii {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> preIndex = new Stack<>();
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            int num = nums[i % nums.length];
            while (!preIndex.isEmpty() && num > nums[preIndex.peek()]) {
                result[preIndex.pop()] = num;
            }
            if (i < nums.length) {
                preIndex.push(i);
            }
        }
        return result;
    }
}
