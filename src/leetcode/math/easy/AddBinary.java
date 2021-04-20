package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/04/20
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        StringBuilder res = new StringBuilder();
        int temp = 0;
        while (p1 >= 0 || p2 >= 0 || temp == 1) {
            if (p1 >= 0 && a.charAt(p1--) == '1') {
                temp++;
            }
            if (p2 >= 0 && b.charAt(p2--) == '1') {
                temp++;
            }
            res.append(temp % 2);
            temp /= 2;
        }
        return res.reverse().toString();
    }
}
