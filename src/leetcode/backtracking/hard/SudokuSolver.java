package leetcode.backtracking.hard;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        help(board, 0, 0);
    }

    public boolean help(char[][] board, int i, int j) {
        int len = board.length;
        if (i == len) {
            return true;
        }
        if (j == len) {
            return help(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return help(board, i, j + 1);
        }
        for (char k = '1'; k <= '9'; k++) {
            if (!isValid(board, i, j, k)) {
                continue;
            }
            board[i][j] = k;
            if (help(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char k) {
        for (int l = 0; l < 9; l++) {
            if (board[i][l] == k) {
                return false;
            }
            if (board[l][j] == k) {
                return false;
            }
            if (board[(i / 3) * 3 + (l / 3)][(j / 3) * 3 + (l % 3)] == k) {
                return false;
            }
        }
        return true;
    }
}
