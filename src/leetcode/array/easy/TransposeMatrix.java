package leetcode.array.easy;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/12/25
 */
public class TransposeMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transpose = new TransposeMatrix().transpose(arr);
        for (int[] ints : transpose) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] transpose(int[][] A) {
        int[][] newArr = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                newArr[j][i] = A[i][j];
            }
        }
        return newArr;
    }

}
