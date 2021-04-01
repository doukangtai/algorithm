package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/01/31
 */
public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(new PartitionEqualSubsetSum()
                .canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().canPartition(new int[]{1, 2, 5}));
        }

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) {
                return false;
            }
            sum /= 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            for (int i = 0; i < nums.length + 1; i++) {
                dp[i][0] = true;
            }
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    if (j - nums[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[nums.length][sum];
        }
    }
}
