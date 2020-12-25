package leetcode.array.medium;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/12/25
 */
public class SubrectangleQueries {

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        for (int[] re : subrectangleQueries.rectangle) {
            System.out.println(Arrays.toString(re));
        }
//        System.out.println(subrectangleQueries.getValue(0, 2));
    }

    int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

}
