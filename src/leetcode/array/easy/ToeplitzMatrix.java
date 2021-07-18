package leetcode.array.easy;

/**
 * @author 窦康泰
 * @date 2021/07/18
 */
public class ToeplitzMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        new ToeplitzMatrix().isToeplitzMatrix(matrix);
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int len = matrix.length + matrix[0].length - 1;
        boolean res = true;
        for (int i = matrix.length - 1; i >= 0; i--) {
            int row = i;
            int col = 0;
            int memo = matrix[row][col];
            while (row < matrix.length && col < matrix[0].length) {
                if (matrix[row][col] != memo) {
                    res = false;
                    break;
                }
                row++;
                col++;
            }
            if (!res) {
                break;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            int col = i;
            int row = 0;
            int memo = matrix[row][col];
            while (row < matrix.length && col < matrix[0].length) {
                if (matrix[row][col] != memo) {
                    res = false;
                    break;
                }
                row++;
                col++;
            }
            if (!res) {
                break;
            }
        }
        return res;
    }
}
