package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/02/13
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5
        ));
    }

    public int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights);
        int right = getSum(weights);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isFinish(weights, D, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isFinish(int[] weights, int D, int target) {
        int j = 0;
        for (int i = 0; i < D; i++) {
            int temp = target;
            while ((temp -= weights[j]) >= 0) {
                j++;
                if (j == weights.length) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getMax(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int weight : weights) {
            max = Math.max(max, weight);
        }
        return max;
    }

    public int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }
}
