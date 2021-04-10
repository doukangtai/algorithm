package leetcode.dfs.medium;

/**
 * @author 窦康泰
 * @date 2021/04/10
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(new int[][]{
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        }));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int res = 1;
        for (int[] dir : direction) {
            res += dfs(grid, i + dir[0], j + dir[1]);
        }
        return res;
    }
}
