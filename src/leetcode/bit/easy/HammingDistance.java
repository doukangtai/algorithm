package leetcode.bit.easy;

/**
 * @author 窦康泰
 * @date 2021/07/19
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                res++;
            }
            num = num >> 1;
        }
        return res;
    }
}
