package leetcode.graph.medium;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2021/07/17
 */
public class CourseScheduleii {
    static class Method1DFS {
        public static void main(String[] args) {
            new Method1DFS().findOrder(2, new int[][]{{1, 0}});
        }

        private static final Integer NOT_START = 0;
        private static final Integer SEARCHING = 1;
        private static final Integer FINISH = 2;
        private List<List<Integer>> edges = new ArrayList<>();
        private int[] visited;
        private boolean flag = true;
        private Stack<Integer> stack = new Stack<>();

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                edges.get(prerequisite[1]).add(prerequisite[0]);
            }
            visited = new int[numCourses];
            for (int i = 0; i < numCourses && flag; i++) {
                if (visited[i] == NOT_START) {
                    dfs(i);
                }
            }
            if (stack.size() == numCourses) {
                int[] result = new int[numCourses];
                for (int i = 0; i < numCourses; i++) {
                    result[i] = stack.pop();
                }
                return result;
            }
            return new int[0];
        }

        private void dfs(int u) {
            visited[u] = SEARCHING;
            for (Integer v : edges.get(u)) {
                if (visited[v] == NOT_START) {
                    dfs(v);
                    if (!flag) {
                        return;
                    }
                } else if (visited[v] == SEARCHING) {
                    flag = false;
                    return;
                }
            }
            visited[u] = FINISH;
            stack.push(u);
        }
    }

    static class Method2BFS {
        public static void main(String[] args) {
            new Method2BFS().findOrder(2, new int[][]{{1, 0}});
        }

        private List<List<Integer>> edges = new ArrayList<>();
        private int[] inDegree;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            Queue<Integer> resultQue = new LinkedList<>();
            while (!queue.isEmpty()) {
                Integer u = queue.poll();
                resultQue.offer(u);
                for (Integer v : edges.get(u)) {
                    inDegree[v]--;
                    if (inDegree[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            if (resultQue.size() == numCourses) {
                int[] result = new int[numCourses];
                for (int i = 0; i < result.length; i++) {
                    result[i] = resultQue.poll();
                }
                return result;
            }
            return new int[0];
        }
    }
}
