package leetcode.dfs.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/04/12
 */
public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        System.out.println(new PacificAtlanticWaterFlow().pacificAtlantic(new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        }));
    }

    int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] canReachLT = new boolean[heights.length][heights[0].length];
        boolean[][] canReachRB = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            dfs(heights, i, 0, canReachLT);
            dfs(heights, i, heights[i].length - 1, canReachRB);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs(heights, 0, i, canReachLT);
            dfs(heights, heights.length - 1, i, canReachRB);
        }
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                if (canReachLT[i][j] && canReachRB[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, int i, int j, boolean[][] canReach) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] = true;
        for (int[] dir : direction) {
            int row = i + dir[0];
            int col = j + dir[1];
            if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || heights[i][j] > heights[row][col]) {
                continue;
            }
            dfs(heights, row, col, canReach);
        }
    }
}
