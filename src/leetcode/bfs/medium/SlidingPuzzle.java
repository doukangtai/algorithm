package leetcode.bfs.medium;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/03/27
 */
public class SlidingPuzzle {
    public static void main(String[] args) {
        System.out.println(new SlidingPuzzle().slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}}));
    }

    public int slidingPuzzle(int[][] board) {
        String pat = "123450";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]);
            }
        }
        String txt = sb.toString();
        List<List<Integer>> indexList = new ArrayList<>();
        indexList.add(new ArrayList<>(Arrays.asList(1, 3)));
        indexList.add(new ArrayList<>(Arrays.asList(0, 2, 4)));
        indexList.add(new ArrayList<>(Arrays.asList(1, 5)));
        indexList.add(new ArrayList<>(Arrays.asList(0, 4)));
        indexList.add(new ArrayList<>(Arrays.asList(3, 1, 5)));
        indexList.add(new ArrayList<>(Arrays.asList(4, 2)));
        List<String> visited = new ArrayList<>();
        visited.add(txt);
        Deque<String> deque = new LinkedList<>();
        deque.push(txt);
        int step = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                String cur = deque.pollFirst();
                if (pat.equals(cur)) {
                    return step;
                }
                int index0 = 0;
                for (int i = 0; i < cur.toCharArray().length; i++) {
                    if (cur.charAt(i) == '0') {
                        index0 = i;
                        break;
                    }
                }
                List<Integer> nextIndexList = indexList.get(index0);
                for (int i = 0; i < nextIndexList.size(); i++) {
                    String newStr = swap(cur, index0, nextIndexList.get(i));
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        deque.addLast(newStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String cur, int index0, Integer nextIndex) {
        char[] charArray = cur.toCharArray();
        char temp = charArray[index0];
        charArray[index0] = charArray[nextIndex];
        charArray[nextIndex] = temp;
        return String.valueOf(charArray);
    }
}
