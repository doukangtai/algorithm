package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/07/18
 */
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int right = arr[0];
        for (int i = 0; i < arr.length; i++) {
            right = Math.max(right, arr[i]);
            if (right == i) {
                res++;
            }
        }
        return res;
    }
}
