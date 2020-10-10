package learn.kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2020/10/10
 */
public class KruskalCase {

    public static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                {0, 12, INF, INF, INF, 16, 14},
                {12, 0, 10, INF, INF, 7, INF},
                {INF, 10, 0, 3, 5, 6, INF},
                {INF, INF, 3, 0, 4, INF, INF},
                {INF, INF, 5, 4, 0, 2, 8},
                {16, 7, 6, INF, 2, 0, 9},
                {14, INF, INF, INF, 8, 9, 0}
        };
        Graph graph = new Graph(vertex, matrix);
//        graph.show();
        Kruskal kruskal = new Kruskal(graph);
//        List<EdgeData> edges = kruskal.getEdges();
//        Collections.sort(edges);
//        System.out.println(edges);
//        System.out.println(edges.size());
        kruskal.kruskal();
    }

}

class Kruskal {

    public Graph graph;

    public Kruskal(Graph graph) {
        this.graph = graph;
    }

    public List<EdgeData> getEdges() {
        int[][] matrix = graph.matrix;
        List<EdgeData> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != Integer.MAX_VALUE) {
                    EdgeData edgeData = new EdgeData(graph.vertex[i], graph.vertex[j], matrix[i][j]);
                    list.add(edgeData);
                }
            }
        }
        return list;
    }

    public int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public int getPosition(char vertex) {
        for (int i = 0; i < graph.vertex.length; i++) {
            if (vertex == graph.vertex[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 克鲁斯卡尔算法（与prim算法都是求最小生成树）
     * 思路：根据图中每条边的权值排序，选择最小权值边作为选出来的边，同时要注意不能成环
     * （判断依据：通过getEnd方法，看两个节点是否以同一个节点结束，若以同一个节点结束，则不能相连）
     */
    public void kruskal() {
        // 寻找指定节点的结束节点
        int[] ends = new int[graph.vertex.length];
        // 存放结果
        List<EdgeData> results = new ArrayList<>();

        // 获取所有边并排序
        List<EdgeData> edges = getEdges();
        Collections.sort(edges);
        for (int i = 0; i < edges.size(); i++) {
            // 获取指定节点对应数组index
            int p1 = getPosition(edges.get(i).start);
            int p2 = getPosition(edges.get(i).end);
            // 获取指定节点以哪个节点结束
            int m = getEnd(ends, p1);
            int n = getEnd(ends, p2);
            // 若不以同一个节点结束，则更新ends，同时将边add进results中
            if (m != n) {
                ends[m] = n;
                results.add(edges.get(i));
            }
        }
        // 遍历结果
        for (EdgeData result : results) {
            System.out.println(result);
        }
    }

}

class EdgeData implements Comparable<EdgeData> {
    public char start;
    public char end;
    public int weight;

    public EdgeData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EdgeData{" +
                "<" + start +
                "," + end +
                "> = " + weight +
                '}';
    }

    @Override
    public int compareTo(EdgeData o) {
        return this.weight - o.weight;
    }
}

class Graph {
    /**
     * 边数
     */
//    public int edgeNum;
    /**
     * 存放节点
     */
    public char[] vertex;
    /**
     * 存放边（邻接矩阵）
     */
    public int[][] matrix;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = i + 1; j < matrix[i].length; j++) {
//                if (matrix[i][j] != Integer.MAX_VALUE) {
//                    edgeNum++;
//                }
//            }
//        }
    }

    public void show() {
//        System.out.println("edgeNum=" + edgeNum);
        System.out.println("vertex=" + Arrays.toString(vertex));
        System.out.println("matrix=");
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%-12d", anInt);
            }
            System.out.println();
        }
    }
}
