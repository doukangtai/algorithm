package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/07/18
 */
public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; nums[j] != -1; ) {
                cnt++;
                int t = nums[j];
                nums[j] = -1;
                j = t;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
