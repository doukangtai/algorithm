package leetcode.math.easy;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class FactorialTrailingZeroes {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().trailingZeroes(25));
        }

        public int trailingZeroes(int n) {
            int res = 0;
            int num = 5;
            int val = 5;
            int i = 1;
            while (val <= n) {
                int temp = val;
                while (temp % 5 == 0) {
                    res++;
                    temp /= 5;
                }
                val = num * ++i;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(25));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        int div = 5;
        while (div <= n) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
