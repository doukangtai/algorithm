package leetcode.graph.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 窦康泰
 * @date 2021/07/16
 */
public class IsGraphBipartite {
    static class Method1DFS {
        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;
        private int[] color;
        private boolean result = true;

        public boolean isBipartite(int[][] graph) {
            color = new int[graph.length];
            for (int i = 0; i < graph.length && result; i++) {
                if (color[i] == UNCOLORED) {
                    dfs(graph, i, RED);
                }
            }
            return result;
        }

        private void dfs(int[][] graph, int index, int c) {
            color[index] = c;
            int toColor = c == RED ? GREEN : RED;
            for (int neighbor : graph[index]) {
                if (color[neighbor] == UNCOLORED) {
                    dfs(graph, neighbor, toColor);
                    if (!result) {
                        return;
                    }
                } else if (color[neighbor] != toColor) {
                    result = false;
                    return;
                }
            }
        }
    }

    static class Method2 {
        public static void main(String[] args) {
            new Method2().isBipartite(new int[][]{{1, 3}, {0, 2}, {1, 3}, {0, 2}});
        }

        private static final int UNCOLORED = 0;
        private static final int RED = 1;
        private static final int GREEN = 2;
        private int[] color;
        private boolean result = true;

        public boolean isBipartite(int[][] graph) {
            color = new int[graph.length];
            for (int i = 0; i < graph.length; i++) {
                if (color[i] == UNCOLORED) {
                    bfs(graph, i, RED);
                }
            }
            return result;
        }

        private void bfs(int[][] graph, int index, int c) {
            color[index] = c;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(index);
            while (!queue.isEmpty()) {
                Integer curNodeIndex = queue.poll();
                int toColor = color[curNodeIndex] == RED ? GREEN : RED;
                for (int neighbor : graph[curNodeIndex]) {
                    if (color[neighbor] == UNCOLORED) {
                        color[neighbor] = toColor;
                        queue.offer(neighbor);
                    } else if (color[neighbor] != toColor) {
                        result = false;
                        return;
                    }
                }
            }
        }
    }
}
