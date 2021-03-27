package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(25));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        int div = 5;
        while (div <= n) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
