package leetcode.array.easy;

/**
 * @author 窦康泰
 * @date 2021/07/17
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        new ReshapeTheMatrix().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int count = mat.length * mat[0].length;
        if (r * c != count) {
            return mat;
        }
        int[][] res = new int[r][c];
        int col = mat[0].length;
        for (int i = 0; i < count; i++) {
            res[i / c][i % c] = mat[i / col][i % col];
        }
        return res;
    }
}
