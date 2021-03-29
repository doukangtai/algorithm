package leetcode.math.medium;

/**
 * @author 窦康泰
 * @date 2021/03/29
 */
public class SumOfSquareNumbers {
    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(4));
    }

    public boolean judgeSquareSum(int c) {
        int lo = 0;
        int hi = (int) Math.ceil(Math.sqrt(c));
        while (lo <= hi) {
            int sum = lo * lo + hi * hi;
            if (sum == c) {
                return true;
            } else if (sum < c) {
                lo++;
            } else {
                hi--;
            }
        }
        return false;
    }
}
