package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(-1));
    }

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (n << i)) != 0) {
                count++;
            }
        }
        System.out.println(count);
        return count == 1;
    }
}
