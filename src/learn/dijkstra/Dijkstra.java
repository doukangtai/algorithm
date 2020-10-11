package learn.dijkstra;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 窦康泰
 * @date 2020/10/11
 */
public class Dijkstra {

    private static final int N = 65535;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {N, 5, 7, N, N, N, 2},
                {5, N, N, 9, N, N, 3},
                {7, N, N, N, 8, N, N},
                {N, 9, N, N, N, 4, N},
                {N, N, 8, N, N, 5, 4},
                {N, N, N, 4, 5, N, 6},
                {2, 3, N, N, 4, 6, N},
        };
        int startIndex = 2;
        Graph graph = new Graph(vertex, matrix);
        graph.show();
        dijkstra(graph, startIndex);
        graph.show();
        showShortestDistance(graph, startIndex);
        System.out.println();
        showShortestPath(graph, startIndex);
    }

    /**
     * 迪杰斯特拉
     * 先初始化第一个节点，
     * 之后循环更新出发节点到当前节点相邻的其它节点的距离，
     * 在未选择的节点中选择一个距离出发节点最近的节点作为新的当前节点，继续循环，最终得到出发点到其它节点的最短距离
     * @param graph
     * @param index
     */
    public static void dijkstra(Graph graph, int index) {
        VisitedVertex visitedVertex = graph.visitedVertex;
        visitedVertex.isVisited[index] = true;
        visitedVertex.distance[index] = 0;
        for (int i = 0; i < graph.vertex.length - 1; i++) {
            update(graph, index);
            index = selectOneNodeAddToVisited(graph);
        }
    }

    public static void update(Graph graph, int index) {
        int[][] matrix = graph.matrix;
        VisitedVertex visitedVertex = graph.visitedVertex;
        for (int i = 0; i < matrix[index].length; i++) {
            if (!visitedVertex.isVisited[i]
                    && visitedVertex.distance[index] + matrix[index][i] < visitedVertex.distance[i]) {
                visitedVertex.distance[i] = visitedVertex.distance[index] + matrix[index][i];
                visitedVertex.preNode[i] = index;
            }
        }
    }

    public static int selectOneNodeAddToVisited(Graph graph) {
        VisitedVertex visitedVertex = graph.visitedVertex;
        int min = N;
        int tempIndex = -1;
        for (int i = 0; i < visitedVertex.isVisited.length; i++) {
            if (!visitedVertex.isVisited[i] && visitedVertex.distance[i] < min) {
                min = visitedVertex.distance[i];
                tempIndex = i;
            }
        }
        visitedVertex.isVisited[tempIndex] = true;
        return tempIndex;
    }

    public static void showShortestDistance(Graph graph, int startIndex) {
        VisitedVertex visitedVertex = graph.visitedVertex;
        for (int i = 0; i < graph.vertex.length; i++) {
            System.out.println("从出发节点\"" + graph.vertex[startIndex] + "\"到节点\"" + graph.vertex[i] + "\"的最短距离：" + visitedVertex.distance[i]);
        }
    }

    public static void showShortestPath(Graph graph, int startIndex) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.vertex.length; i++) {
            int index = i;
            stack.clear();
            stack.add(index);
            while (graph.visitedVertex.preNode[index] != -1) {
                stack.add(graph.visitedVertex.preNode[index]);
                index = graph.visitedVertex.preNode[index];
            }
            System.out.print("从出发节点\"" + graph.vertex[startIndex] + "\"到节点\"" + graph.vertex[i] + "\"所走的路径为：");
            while (!stack.isEmpty()) {
                if (stack.size() > 1) {
                    System.out.print(stack.pop() + "-->");
                } else {
                    System.out.println(stack.pop());
                }
            }
        }
    }

}

class VisitedVertex {

    /**
     * 节点是否被访问过
     */
    public boolean[] isVisited;
    /**
     * 出发点到其它节点的距离
     */
    public int[] distance;
    /**
     * 每个节点index对应的值为前一个节点index
     */
    public int[] preNode;

    public VisitedVertex(int vertexNum) {
        this.isVisited = new boolean[vertexNum];
        this.distance = new int[vertexNum];
        this.preNode = new int[vertexNum];
        Arrays.fill(distance, 65535);
        Arrays.fill(preNode, -1);
    }

    public void show() {
        System.out.print("isVisited=[");
        for (int i = 0; i < isVisited.length; i++) {
            System.out.printf("%10s", isVisited[i]);
        }
        System.out.println("]");

        System.out.print("distance =[");
        for (int i = 0; i < distance.length; i++) {
            System.out.printf("%10s", distance[i]);
        }
        System.out.println("]");

        System.out.print("preNode  =[");
        for (int i = 0; i < preNode.length; i++) {
            System.out.printf("%10s", preNode[i]);
        }
        System.out.println("]");

    }
}

class Graph {

    /**
     * 节点数组
     */
    public char[] vertex;
    /**
     * 邻接矩阵，记录节点连通性
     */
    public int[][] matrix;

    /**
     * 动态更新节点信息
     */
    public VisitedVertex visitedVertex;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
        this.visitedVertex = new VisitedVertex(vertex.length);
    }

    public void show() {
        System.out.println("vertex=" + Arrays.toString(vertex));
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("matrix=[");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%8d", matrix[i][j]);
            }
            System.out.println("]");
        }
        System.out.println();

        visitedVertex.show();
        System.out.println();
    }
}
