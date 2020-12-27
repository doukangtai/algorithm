package leetcode.array.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/12/26
 */
public class MagneticForceBetweenTwoBalls {

    public static void main(String[] args) {
//        int[] position = new int[]{1, 2, 3, 4, 7};
//        int m = 3;
        int[] position = new int[]{5, 4, 3, 2, 1, 1000000000};
        int m = 2;
        System.out.println(new MagneticForceBetweenTwoBalls().maxDistance(position, m));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1;
        int right = position[position.length - 1] - position[0];
        int value = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(mid, position, m)) {
                value = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return value;
    }

    public boolean check(int key, int[] position, int m) {
        int count = 1;
        int pre = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= key) {
                count++;
                pre = position[i];
            }
        }
        return count >= m;
    }

}
