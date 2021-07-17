package leetcode.graph.medium;

/**
 * @author 窦康泰
 * @date 2021/07/17
 */
public class RedundantConnection {
    private int[] parents;

    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    private void union(int node1, int node2) {
        parents[find(node1)] = find(node2);
    }

    private int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }
}
