package leetcode.math.medium;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("3", "6"));
    }

    public String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int[] res = new int[chars1.length + chars2.length];
        for (int i = chars2.length - 1; i >= 0; i--) {
            for (int j = chars1.length - 1; j >= 0; j--) {
                int temp = (chars2[i] - '0') * (chars1[j] - '0');
                int sum = temp + res[i + j + 1];
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }
        int i;
        for (i = 0; i < res.length; i++) {
            if (res[i] != 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = i; j < res.length; j++) {
            sb.append(res[j]);
        }
        String s = sb.toString();
        return "".equals(s) ? "0" : s;
    }
}
