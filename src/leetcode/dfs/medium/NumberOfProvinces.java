package leetcode.dfs.medium;

/**
 * @author 窦康泰
 * @date 2021/04/11
 */
public class NumberOfProvinces {
    public static void main(String[] args) {
        System.out.println(new NumberOfProvinces().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                res++;
                dfs(isConnected, i);
            }
        }
        return res;
    }

    private void dfs(int[][] isConnected, int i) {
        visited[i] = true;
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                dfs(isConnected, j);
            }
        }
    }
}
