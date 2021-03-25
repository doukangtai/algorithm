package leetcode.greedy.medium;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class JumpGame {
    class Method2 {
        public boolean canJump(int[] nums) {
            int len = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                len = Math.max(len, i + nums[i]);
                if (len <= i) {
                    return false;
                }
            }
            return len >= nums.length - 1;
        }
    }

    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int step = nums[0];
        for (int i = 1; i < nums.length; i++) {
            step--;
            if (step <= nums[i]) {
                step = nums[i];
            }
            if (i == nums.length - 1) {
                return true;
            }
            if (step == 0) {
                return false;
            }
        }
        return true;
    }
}
