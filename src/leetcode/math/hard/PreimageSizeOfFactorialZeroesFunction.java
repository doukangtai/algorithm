package leetcode.math.hard;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class PreimageSizeOfFactorialZeroesFunction {
    public static void main(String[] args) {
        System.out.println(new PreimageSizeOfFactorialZeroesFunction().preimageSizeFZF(5));
    }

    public int preimageSizeFZF(int K) {
        long left = 0;
        long right = Integer.MAX_VALUE;
        if (trailingZeroes(Integer.MAX_VALUE) < K) {
            right = Long.MAX_VALUE;
        }
        return (int) (rightBound(left, right, K) - leftBound(left, right, K) + 1);
    }

    public long rightBound(long left, long right, int K) {
        if (left > right) {
            return -1;
        }
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (trailingZeroes(mid) < K) {
                left = mid + 1;
            } else if (trailingZeroes(mid) > K) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public long leftBound(long left, long right, int K) {
        if (left > right) {
            return -1;
        }
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (trailingZeroes(mid) < K) {
                left = mid + 1;
            } else if (trailingZeroes(mid) > K) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long trailingZeroes(long n) {
        long res = 0;
        long div = 5;
        while (div <= n) {
            res += n / div;
            div *= 5;
        }
        return res;
    }
}
