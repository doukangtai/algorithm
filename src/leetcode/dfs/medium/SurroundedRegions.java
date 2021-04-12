package leetcode.dfs.medium;

/**
 * @author 窦康泰
 * @date 2021/04/12
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{{'O', 'O'}, {'O', 'O'}});
    }

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Y') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X' || board[i][j] == 'Y') {
            return;
        }
        board[i][j] = 'Y';
        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : direction) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}
