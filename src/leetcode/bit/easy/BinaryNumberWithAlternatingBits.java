package leetcode.bit.easy;

/**
 * @author 窦康泰
 * @date 2021/07/19
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int temp = (n ^ (n >> 1));
        return 0 == (temp & (temp + 1));
    }
}
