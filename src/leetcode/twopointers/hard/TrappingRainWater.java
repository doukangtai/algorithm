package leetcode.twopointers.hard;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(new int[]{}));
    }

    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int lMax= height[left];
        int rMax = height[right];
        int res = 0;
        while (left <= right) {
            if (height[left] > lMax) {
                lMax = height[left];
            }
            if (height[right] > rMax) {
                rMax = height[right];
            }
            if (lMax < rMax) {
                res += lMax - height[left];
                left++;
            } else {
                res += rMax - height[right];
                right--;
            }
        }
        return res;
    }
}
