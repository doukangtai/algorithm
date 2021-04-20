package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int n = 1;
        while (num > 0) {
            num -= n;
            n += 2;
        }
        return num == 0;
    }
}
