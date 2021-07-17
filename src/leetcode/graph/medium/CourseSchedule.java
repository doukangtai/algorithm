package leetcode.graph.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 窦康泰
 * @date 2021/07/17
 */
public class CourseSchedule {
    static class Method1DFS {
        private static final Integer NOT_START = 0;
        private static final Integer SEARCHING = 1;
        private static final Integer FINISH = 2;
        private List<List<Integer>> edges = new ArrayList<>();
        private int[] visited;
        private boolean result = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                edges.get(prerequisite[1]).add(prerequisite[0]);
            }
            visited = new int[numCourses];
            for (int i = 0; i < numCourses && result; i++) {
                if (visited[i] == NOT_START) {
                    dfs(i);
                }
            }
            return result;
        }

        private void dfs(int u) {
            visited[u] = SEARCHING;
            for (Integer v : edges.get(u)) {
                if (visited[v] == NOT_START) {
                    dfs(v);
                    if (!result) {
                        return;
                    }
                } else if (visited[v] == SEARCHING) {
                    result = false;
                    return;
                }
            }
            visited[u] = FINISH;
        }
    }

    static class Method2BFS {
        public static void main(String[] args) {
            new Method2BFS().canFinish(2, new int[][]{{1, 0}});
        }

        private List<List<Integer>> edges = new ArrayList<>();
        private int[] inDegree;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            inDegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                edges.get(prerequisite[1]).add(prerequisite[0]);
                inDegree[prerequisite[0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            int count = 0;
            while (!queue.isEmpty()) {
                Integer u = queue.poll();
                count++;
                for (Integer v : edges.get(u)) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            return count == numCourses;
        }
    }
}
