package leetcode.bit.easy;

/**
 * @author 窦康泰
 * @date 2021/07/19
 */
public class NumberComplement {
    public int findComplement(int num) {
        int temp = 1 << 30;
        while ((temp & num) == 0) {
            temp = temp >> 1;
        }
        return ((temp << 1) - 1) ^ num;
    }
}
