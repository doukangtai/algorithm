package leetcode.greedy.easy;

/**
 * @author 窦康泰
 * @date 2021/04/05
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{0}, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int p = 0;
        while (p < flowerbed.length) {
            if (flowerbed[p] == 1) {
                p++;
            } else if (flowerbed[p] == 0) {
                if (p > 0 && p < flowerbed.length - 1 && flowerbed[p - 1] == 0 && flowerbed[p + 1] == 0) {
                    flowerbed[p] = 1;
                    n--;
                } else if (p == flowerbed.length - 1 && p - 1 >= 0 && flowerbed[p - 1] == 0) {
                    flowerbed[p] = 1;
                    n--;
                } else if (p == 0 && p + 1 <= flowerbed.length - 1 && flowerbed[p + 1] == 0) {
                    flowerbed[p] = 1;
                    n--;
                } else if (flowerbed.length == 1 && flowerbed[0] == 0) {
                    flowerbed[p] = 1;
                    n--;
                }
                p++;
            }
        }
        return n <= 0;
    }
}
