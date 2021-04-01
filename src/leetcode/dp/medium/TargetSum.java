package leetcode.dp.medium;

/**
 * @author 窦康泰
 * @date 2021/02/21
 */
public class TargetSum {
    private int res;

    public int findTargetSumWays(int[] nums, int S) {
        help(nums, S, 0);
        return res;
    }

    public void help(int[] nums, int S, int index) {
        if (index == nums.length) {
            if (S == 0) {
                res++;
            }
            return;
        }
        S -= nums[index];
        help(nums, S, index + 1);
        S += nums[index];
        S += nums[index];
        help(nums, S, index + 1);
        S -= nums[index];
    }

    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
        }

        public int findTargetSumWays(int[] nums, int S) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum < S) {
                return 0;
            }
            sum = sum + S;
            if (sum % 2 != 0) {
                return 0;
            }
            sum /= 2;
            int[][] dp = new int[nums.length + 1][sum + 1];
            dp[0][0] = 1;
            for (int i = 1; i < nums.length + 1; i++) {
                for (int j = 0; j < sum + 1; j++) {
                    if (j - nums[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            return dp[nums.length][sum];
        }
    }
}
