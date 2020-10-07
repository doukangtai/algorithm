package learn.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2020/10/04
 */
public class HuffmanTree {

    public static void main(String[] args) {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        Node root = huffmanTree(array);
//        preOrder(root);
//        infixOrder(root);
//        postOrder(root);
    }

    /**
     * 哈夫曼树（最优二叉树）：每次取两个最小权重的节点，求和后与剩下的节点重复前面的步骤
     * 思路：将所有节点add进list中，排序后取最小的两个节点（remove掉）进行求和再add进list中，循环即可
     * @param array
     * @return
     */
    public static Node huffmanTree(int[] array) {
        List<Node> nodes = new ArrayList<>();
        for (int i : array) {
            nodes.add(new Node(i));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node leftNode = nodes.remove(0);
            Node rightNode = nodes.remove(0);
            Node newNode = new Node(leftNode.value + rightNode.value);
            newNode.left = leftNode;
            newNode.right = rightNode;
            nodes.add(newNode);
        }
        return nodes.get(0);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void infixOrder(Node root) {
        if (root == null) {
            return;
        }
        infixOrder(root.left);
        System.out.println(root);
        infixOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }

}

class Node implements Comparable<Node> {
    public Integer value;
    public Node left;
    public Node right;

    public Node(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
