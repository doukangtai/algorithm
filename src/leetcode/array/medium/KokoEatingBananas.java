package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/02/13
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        System.out.println(new KokoEatingBananas().minEatingSpeed(
                new int[]{3, 6, 7, 11}, 8
        ));
    }

    public int minEatingSpeed(int[] piles, int H) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int min = 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isFinish(piles, H, mid)) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean isFinish(int[] piles, int H, int target) {
        int sum = 0;
        for (int pile : piles) {
            sum += (pile / target) + (pile % target == 0 ? 0 : 1);
        }
        return sum <= H;
    }
}
