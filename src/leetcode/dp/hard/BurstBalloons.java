package leetcode.dp.hard;

/**
 * @author 窦康泰
 * @date 2021/03/25
 */
public class BurstBalloons {
    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8}));
    }

    public int maxCoins(int[] nums) {
        int[] arr = new int[nums.length + 2];
        arr[0] = arr[arr.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int i = dp.length - 3; i >= 0; i--) {
            for (int j = i + 2; j < nums.length + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[i] * arr[k] * arr[j]);
                }
            }
        }
        return dp[0][nums.length + 1];
    }
}
