package leetcode.array;

/**
 * 4. 寻找两个有序数组的中位数  https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

    /**
     * 法一：两个有序数组分别从小到大依次比较，直到比较len / 2 + 1次，若len为偶数，则中位数为(left + right) / 2.0，否则为right
     * 时间复杂度：O(m+n) 空间复杂度O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int aStart = 0, bStart = 0;
        int left = -1, right = -1;
        int n = nums1.length;
        int m = nums2.length;
        for (int i = 0; i < len / 2 + 1; i++) {
            left = right;
            if (aStart < n && (bStart >= m || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }
    }

    /**
     * 法二：利用iMin和iMax进行二分，注意临界条件i, j = 0和i = m, j = n;
     * 由于 0 <= i <= m，为了保证 0 <= j <= n，我们必须保证 m <= n。
     * m≤n,i<m,j=(m+n+1)/2−i≥(m+m+1)/2−i>(m+m+1)/2−m=0
     * m≤n,i>0,j=(m+n+1)/2−i≤(n+n+1)/2−i<(n+n+1)/2=n
     * 时间复杂度：O(log(min(m，n)))   空间复杂度：O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysTwo(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int iMin = 0, iMax = m;
        if (m > n) {
            return findMedianSortedArraysTwo(nums2, nums1);
        }
        while (iMin <= iMax) {
            int i = (iMax + iMin) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i != 0 && j != n && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else if (j != 0 && i != m && nums2[j - 1] > nums1[i]) {
                iMin = i + 1;
            } else {
                int maxLeft = 0, minRight = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums1[i], nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double medianSortedArrays = medianOfTwoSortedArrays.findMedianSortedArraysTwo(new int[]{1, 3}, new int[]{2});
        System.out.println(medianSortedArrays);
    }

}
