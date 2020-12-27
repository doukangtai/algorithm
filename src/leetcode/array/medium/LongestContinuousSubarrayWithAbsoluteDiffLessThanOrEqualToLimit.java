package leetcode.array.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 窦康泰
 * @date 2020/12/27
 */
public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2};
        int limit = 2;
        System.out.println(new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit().longestSubarray(nums, limit));
    }

//    public int longestSubarray(int[] nums, int limit) {
//        int maxLen = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int rear = i;
//            int max = nums[i];
//            int min = nums[i];
//            int nextI = i;
//            boolean flag = true;
//            while (Math.abs(max - min) <= limit) {
//                if (nums[rear] != nums[i]) {
//                    flag = false;
//                }
//                if (flag) {
//                    nextI = rear;
//                }
//                maxLen = Math.max(maxLen, rear - i);
//                rear++;
//                if (rear >= nums.length) {
//                    break;
//                }
//                max = Math.max(max, nums[rear]);
//                min = Math.min(min, nums[rear]);
//            }
//            i = nextI;
//        }
//        return maxLen + 1;
//    }

    public int longestSubarray(int[] nums, int limit) {
        // 两个双端队列维护nums中在窗口内的最大值和最小值
        // maxQ由大到小
        Deque<Integer> maxQ = new LinkedList<>();
        // minQ由小到大
        Deque<Integer> minQ = new LinkedList<>();
        int ans = 0;
        // 左窗口
        int start = 0;
        // 右窗口end
        for (int end = 0; end < nums.length; end++) {
            // 维护maxQ
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[end]) {
                maxQ.pollLast();
            }
            maxQ.add(end);
            // 维护minQ
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[end]) {
                minQ.pollLast();
            }
            minQ.add(end);
            // 大于limit表示不再范围内，左窗口右移缩小范围，否则跳出while进入下次for，即右窗口右移扩大范围
            while (!maxQ.isEmpty() && !minQ.isEmpty() && nums[maxQ.peek()] - nums[minQ.peek()] > limit) {
                if (maxQ.peek() <= start) {
                    maxQ.poll();
                }
                if (minQ.peek() <= start) {
                    minQ.poll();
                }
                start++;
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }

}
