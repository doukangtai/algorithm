package leetcode.array.medium;

/**
 * @author 窦康泰
 * @date 2021/07/17
 */
public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0];
        int r = matrix[n - 1][n - 1];
        while (l < r) {
            int mid = l + (r - l) / 2;
            int row = n - 1;
            int col = 0;
            int count = 0;
            while (row >= 0 && col < n) {
                if (matrix[row][col] > mid) {
                    row--;
                } else {
                    count += row + 1;
                    col++;
                }
            }
            if (count >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
