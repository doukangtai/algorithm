package leetcode.bfs.medium;

import java.util.LinkedList;

/**
 * @author 窦康泰
 * @date 2021/04/09
 */
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        System.out.println(new ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int res = 0;
        if (grid[0][0] != 0) {
            return -1;
        }
        int[][] path = {{1, 1}, {1, 0}, {0, 1}, {-1, -1}, {-1, 0}, {0, -1}, {-1, 1}, {1, -1}};
        int n = grid.length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            while (size-- > 0) {
                int[] first = queue.removeFirst();
                if (first[0] == n - 1 && first[1] == n - 1) {
                    return res;
                }
                for (int[] p : path) {
                    int row = first[0] + p[0];
                    int col = first[1] + p[1];
                    if (row >= 0 && row < n && col >= 0 && col < n && grid[row][col] == 0) {
                        queue.add(new int[]{row, col});
                        grid[row][col] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
