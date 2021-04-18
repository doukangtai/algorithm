package leetcode.backtracking.hard;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2021/03/26
 */
public class SudokuSolver {
    static class Method2 {
        public static void main(String[] args) {
            char[][] board = {
                    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            new Method2().solveSudoku(board);
            for (char[] b : board) {
                System.out.println(Arrays.toString(b));
            }
        }

        public void solveSudoku(char[][] board) {
            help(board, 0, 0);
        }

        public boolean help(char[][] board, int row, int col) {
            int n = board.length;
            int m = board[0].length;
            if (row >= n || col >= m) {
                return true;
            }
            if (board[row][col] != '.') {
                boolean flag;
                if (col == m - 1) {
                    flag = help(board, row + 1, 0);
                } else {
                    flag = help(board, row, col + 1);
                }
                if (flag) {
                    return true;
                }
            } else {
                for (char i = '1'; i <= '9'; i++) {
                    if (!valid(board, row, col, i)) {
                        continue;
                    }
                    board[row][col] = i;
                    boolean flag;
                    if (col == m - 1) {
                        flag = help(board, row + 1, 0);
                    } else {
                        flag = help(board, row, col + 1);
                    }
                    if (flag) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
            return false;
        }

        private boolean valid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[row][i] == c) {
                    return false;
                }
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == c) {
                    return false;
                }
            }
            row = row / 3 * 3;
            col = col / 3 * 3;
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] == c) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

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
