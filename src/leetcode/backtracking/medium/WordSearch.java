package leetcode.backtracking.medium;

/**
 * @author 窦康泰
 * @date 2021/04/16
 */
public class WordSearch {
    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (help(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private boolean help(char[][] board, String word, int index, int i, int j) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '0' || board[i][j] != word.charAt(index)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '0';
        for (int[] dir : direction) {
            int row = dir[0] + i;
            int col = dir[1] + j;
            if (help(board, word, index + 1, row, col)) {
                return true;
            }
        }
        board[i][j] = c;
        return false;
    }
}
