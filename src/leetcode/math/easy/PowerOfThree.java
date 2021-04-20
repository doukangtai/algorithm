package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        while (n % 3 == 0 && n > 1) {
            n /= 3;
        }
        return n == 1;
    }
}
