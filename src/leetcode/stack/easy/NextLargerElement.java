package leetcode.stack.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 窦康泰
 * @create 2020-07-15 18:55
 * https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class NextLargerElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                hashMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            hashMap.put(stack.pop(), -1);
        }
        int[] arr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            arr[i] = hashMap.get(nums1[i]);
        }
        return arr;
    }

}
