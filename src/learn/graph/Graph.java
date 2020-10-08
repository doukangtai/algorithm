package learn.graph;

import java.util.*;

/**
 * @author 窦康泰
 * @date 2020/10/08
 */
public class Graph {

    /**
     * 存储顶点集合
     */
    private List<String> vertexList;

    /**
     * 存储图对应的邻接矩阵
     */
    private int[][] edges;

    /**
     * 表示边的数目
     */
    private int numOfEdges;

    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexS = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        for (String vertex : vertexS) {
            graph.insertVertex(vertex);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
//        graph.dfs();
        graph.bfs();
    }

    /**
     * 获取指定index的第一个相邻节点index
     *
     * @param index
     * @return
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取edges[v1][v2]的下一个节点index
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     * 优先进行dfs递归进行深度遍历，
     * 次之通过回溯getNextNeighbor进行广度遍历
     *
     * @param isVisited
     * @param index
     */
    public void dfs(boolean[] isVisited, int index) {
        System.out.print(getValueByIndex(index) + "-->");
        isVisited[index] = true;
        int firstNeighbor = getFirstNeighbor(index);
        while (firstNeighbor != -1) {
            if (!isVisited[firstNeighbor]) {
                dfs(isVisited, firstNeighbor);
            }
            firstNeighbor = getNextNeighbor(index, firstNeighbor);
        }
    }

    public void dfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }

    /**
     * 广度优先遍历
     * 优先通过一个点访问尽可能多的点，并放入queue，
     * 再从queue中取值继续进行广度优先遍历，
     * @param isVisited
     * @param index
     */
    public void bfs(boolean[] isVisited, int index) {
        System.out.print(getValueByIndex(index) + "-->");
        isVisited[index] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(index);
        while (!queue.isEmpty()) {
            Integer first = queue.removeFirst();
            int firstNeighbor = getFirstNeighbor(first);
            while (firstNeighbor != -1) {
                if (!isVisited[firstNeighbor]) {
                    System.out.print(getValueByIndex(firstNeighbor) + "-->");
                    isVisited[firstNeighbor] = true;
                    queue.addLast(firstNeighbor);
                }
                firstNeighbor = getNextNeighbor(first, firstNeighbor);
            }
        }
    }

    public void bfs() {
        for (int i = 0; i < vertexList.size(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdge() {
        return numOfEdges;
    }

    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
