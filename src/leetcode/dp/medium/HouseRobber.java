package leetcode.dp.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/01/28
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
    }

    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(nums[start] + dp(nums, start + 2), dp(nums, start + 1));
        memo[start] = res;
        return res;
    }
}

class HouseRobber2 {
    public int rob(int[] nums) {
        int[] res = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = Math.max(nums[i] + res[i + 2], res[i + 1]);
        }
        return res[0];
    }
}

class HouseRobber3 {
    public int rob(int[] nums) {
        int pre = 0;
        int next = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = pre;
            pre = Math.max(nums[i] + next, pre);
            next = temp;
        }
        return pre;
    }
}
