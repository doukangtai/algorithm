package leetcode.twopointers.easy;

/**
 * @author 窦康泰
 * @date 2021/03/29
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sortArr = new int[n + m];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                sortArr[p++] = nums1[p1++];
            } else {
                sortArr[p++] = nums2[p2++];
            }
        }
        while (p1 < m) {
            sortArr[p++] = nums1[p1++];
        }
        while (p2 < n) {
            sortArr[p++] = nums2[p2++];
        }
        System.arraycopy(sortArr, 0, nums1, 0, n + m);
    }
}
