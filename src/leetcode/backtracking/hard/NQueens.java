package leetcode.backtracking.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/01/22
 */
public class NQueens {
    static class Method2 {
        public static void main(String[] args) {
            System.out.println(new Method2().solveNQueens(4));
        }
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new ArrayList<>();
            char[][] board = new char[n][n];
            for (char[] b : board) {
                Arrays.fill(b, '.');
            }
            help(res, board, 0);
            return res;
        }

        private void help(List<List<String>> res, char[][] board, int row) {
            if (row >= board.length) {
                List<String> list = new ArrayList<>();
                for (char[] b : board) {
                    list.add(String.valueOf(b));
                }
                res.add(list);
                return;
            }
            for (int col = 0; col < board[0].length; col++) {
                if (!valid(board, row, col)) {
                    continue;
                }
                board[row][col] = 'Q';
                help(res, board, row + 1);
                board[row][col] = '.';
            }
        }

        private boolean valid(char[][] board, int row, int col) {
            for (int i = 0; i < row; i++) {
                if (board[i][col] == 'Q') {
                    return false;
                }
            }
            int r = row;
            int c = col;
            while (r >= 0 && c >= 0) {
                if (board[r--][c--] == 'Q') {
                    return false;
                }
            }
            r = row;
            c = col;
            while (r >= 0 && c < board.length) {
                if (board[r--][c++] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        List<List<String>> solveNQueens = new NQueens().solveNQueens(4);
        System.out.println(solveNQueens);
    }

    List<List<String>> res = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        LinkedList<String> board = new LinkedList<>();
        backTracking(board, 0, n);
        return res;
    }

    public void backTracking(LinkedList<String> board, int row, int n) {
        if (row == n) {
            res.add(new LinkedList<>(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(board, row, col, n)) {
                continue;
            }
            board.add(genBoardRow(col, n));
            backTracking(board, row + 1, n);
            board.removeLast();
        }
    }

    public String genBoardRow(int col, int n) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = i == col ? 'Q' : '.';
        }
        return new String(chars);
    }

    public boolean isValid(LinkedList<String> board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            char c = board.get(i).charAt(col);
            if (c == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            char c = board.get(i).charAt(j);
            if (c == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            char c = board.get(i).charAt(j);
            if (c == 'Q') {
                return false;
            }
        }
        return true;
    }
}
