package leetcode.array.easy;

/**
 * @author 窦康泰
 * @date 2021/01/21
 */
public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(4));
    }

    /**
     * 法二：迭代
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int pre = 0;
        int next = 1;
        for (int i = 2; i <= n; i++) {
            int val = pre + next;
            pre = next;
            next = val;
        }
        return next;
    }

//    /**
//     * 法一：递归
//     * @param memo
//     * @param n
//     * @return
//     */
//    public int helper(int[] memo, int n) {
//        if (memo[n] != 0) {
//            return memo[n];
//        }
//        if (n == 0) {
//            return 0;
//        } else if (n == 1) {
//            return 1;
//        }
//        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
//        return memo[n];
//    }
//
//    public int fib(int n) {
//        return helper(new int[n + 1], n);
//    }
}
