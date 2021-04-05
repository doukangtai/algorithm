package leetcode.greedy.easy;

/**
 * @author 窦康泰
 * @date 2021/04/05
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{5, 7, 1, 8}));
    }

    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }
        }
        return count <= 1;
    }
}
