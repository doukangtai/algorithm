package learn.floyd;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2020/10/11
 */
public class Floyd {

    private static final int N = 65535;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 5, 7, N, N, N, 2},
                {5, 0, N, 9, N, N, 3},
                {7, N, 0, N, 8, N, N},
                {N, 9, N, 0, N, 4, N},
                {N, N, 8, N, 0, 5, 4},
                {N, N, N, 4, 5, 0, 6},
                {2, 3, N, N, 4, 6, 0},
        };
        int startIndex = 2;
        Graph graph = new Graph(vertex, matrix);
        graph.show();
        floyd(graph);
        graph.show();
        showShortestDistance(graph);
        System.out.println();
        showShortestPath(graph);
    }

    /**
     * 弗洛伊德算法：求出图中任意两点间的最短距离
     * 三层for循环，每次选择一个中间节点k，若从i到k的距离加上k到j的距离小于i到j的距离则更新i到j的距离，同时更新从i到j的前驱为k到j的前驱
     * @param graph
     */
    public static void floyd(Graph graph) {
        for (int k = 0; k < graph.vertex.length; k++) {
            for (int i = 0; i < graph.vertex.length; i++) {
                for (int j = 0; j < graph.vertex.length; j++) {
                    if (graph.distance[i][k] + graph.distance[k][j] < graph.distance[i][j]) {
                        graph.distance[i][j] = graph.distance[i][k] + graph.distance[k][j];
                        graph.preNode[i][j] = graph.preNode[k][j];
                    }
                }
            }
        }
    }

    public static void showShortestDistance(Graph graph) {
        for (int i = 0; i < graph.vertex.length; i++) {
            for (int j = i + 1; j < graph.vertex.length; j++) {
                System.out.println("从节点\"" + graph.vertex[i] + "\"到节点\"" + graph.vertex[j] + "\"最短距离：" + graph.distance[i][j]);
            }
        }
    }

    public static void showShortestPath(Graph graph) {
        int start = 0;
        int end = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.vertex.length; i++) {
            start = i;
            for (int j = i + 1; j < graph.vertex.length; j++) {
                stack.clear();
                end = j;
                stack.add(end);
                while (graph.preNode[start][end] != start) {
                    end = graph.preNode[start][end];
                    stack.add(end);
                }
                stack.add(start);
                System.out.print("从节点\"" + graph.vertex[i] + "\"到节点\"" + graph.vertex[j] + "\"所经过的节点：");
                while (!stack.isEmpty()) {
                    if (stack.size() > 1) {
                        System.out.print(graph.vertex[stack.pop()] + "---");
                    } else {
                        System.out.print(graph.vertex[stack.pop()]);
                    }
                }
                System.out.println();
            }
        }
    }

}

class Graph {
    /**
     * 保存节点
     */
    public char[] vertex;
    /**
     * 保存从各个节点到其它节点的距离
     */
    public int[][] distance;
    /**
     * 保存到达目标节点的前驱节点
     */
    public int[][] preNode;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.distance = matrix;
        this.preNode = new int[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            Arrays.fill(preNode[i], i);
        }
    }

    public void show() {
        System.out.println("vertex=" + Arrays.toString(vertex));
        System.out.println();

        for (int i = 0; i < distance.length; i++) {
            System.out.print("distance=[");
            for (int j = 0; j < distance[i].length; j++) {
                System.out.printf("%8d", distance[i][j]);
            }
            System.out.println("]");
        }
        System.out.println();

        for (int i = 0; i < preNode.length; i++) {
            System.out.print("preNode=[");
            for (int j = 0; j < preNode[i].length; j++) {
                System.out.printf("%8d", preNode[i][j]);
            }
            System.out.println("]");
        }
        System.out.println();
    }
}
