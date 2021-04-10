package leetcode.dfs.medium;

/**
 * @author 窦康泰
 * @date 2021/04/10
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        System.out.println(new NumberOfIslands().numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, i, j) > 0) {
                    res++;
                }
            }
        }
        return res;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        int res = 1;
        int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : direction) {
            res += dfs(grid, i + dir[0], j + dir[1]);
        }
        return res;
    }
}
