package leetcode.bit.easy;

/**
 * @author 窦康泰
 * @date 2021/07/19
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
    }
}
