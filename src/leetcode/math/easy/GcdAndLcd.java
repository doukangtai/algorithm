package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/04/19
 */
public class GcdAndLcd {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int lcd(int a, int b) {
        return a * b / gcd(a, b);
    }
}
