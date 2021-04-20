package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class AddStrings {
    public String addStrings(String num1, String num2) {
        int p1 = num1.length() - 1;
        int p2 = num2.length() - 1;
        int temp = 0;
        StringBuilder res = new StringBuilder();
        while (p1 >= 0 || p2 >= 0 || temp == 1) {
            int r1 = 0;
            if (p1 >= 0) {
                r1 = num1.charAt(p1--) - '0';
            }
            int r2 = 0;
            if (p2 >= 0) {
                r2 = num2.charAt(p2--) - '0';
            }
            temp = r1 + r2 + temp;
            res.append(temp % 10);
            temp /= 10;
        }
        return res.reverse().toString();
    }
}
