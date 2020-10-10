package learn.prim;

import java.util.Arrays;

/**
 * @author 窦康泰
 * @date 2020/10/10
 */
public class Prim {

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };
        Graph graph = new Graph(data.length, data, weight);
//        graph.show();
        MinTree minTree = new MinTree();
        minTree.prim(graph, 3);
    }

}

/**
 * 创建最小生成树（村庄连接图）
 */
class MinTree {

    /**
     * 普利姆算法
     * 求村庄连通时，所有路径长度最小值，
     * 思路：从某个点开始（并标记为已访问过），寻找与之相邻却未访问过的点并且权值最小的点，即为目标点，
     * 并标记为已访问过，继续从已访问过的点中寻找与之相邻却未访问过的点并且权值最小的点
     * @param graph
     * @param index
     */
    public void prim(Graph graph, int index) {
        // 标记哪个点被访问过
        boolean[] visited = new boolean[graph.vertexNum];
        System.out.println(graph.data[index] + "-->");
        visited[index] = true;
        // 共需要生成graph.vertexNum - 1条边
        for (int i = 0; i < graph.vertexNum - 1; i++) {
            // 记录最小权值
            int minWeight = 10000;
            // 记录已访问过的点
            int tempJ = 0;
            // 记录将要访问的点
            int tempK = 0;
            for (int j = 0; j < graph.vertexNum; j++) {
                // 查找已经访问过的点
                if (!visited[j]) {
                    continue;
                }
                for (int k = 0; k < graph.vertexNum; k++) {
                    // 查找未访问过的点，并将小于minWeight的点信息记录下来
                    if (!visited[k] && graph.weight[j][k] < minWeight) {
                        minWeight = graph.weight[j][k];
                        tempJ = j;
                        tempK = k;

                    }
                }
            }
            // 将访问过的点输出，并标记访问过
            System.out.print(graph.data[tempK] + "-->");
            visited[tempK] = true;
            // 输出生成的边
            System.out.println("    <" + graph.data[tempJ] + "," + graph.data[tempK] + ">");
        }
    }

}

class Graph {
    /**
     * 节点数
     */
    public int vertexNum;
    /**
     * 存放节点数据
     */
    public char[] data;
    /**
     * 存放边（邻接矩阵）
     */
    public int[][] weight;

    public Graph(int vertexNum, char[] data, int[][] weight) {
        this.vertexNum = vertexNum;
        this.data = data;
        this.weight = weight;
    }

    public void show() {
        System.out.println("vertexNum=" + vertexNum);
        System.out.println("data=" + Arrays.toString(data));
        System.out.println("weight=");
        for (int[] ints : weight) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
