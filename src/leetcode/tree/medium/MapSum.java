package leetcode.tree.medium;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class MapSum {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap"));
    }

    class Node {
        Node[] nodes = new Node[26];
        int val;
    }

    private Node root = new Node();

    public MapSum() {
    }

    public void insert(String key, int val) {
        insert(key, root, val);
    }

    private void insert(String key, Node node, int val) {
        if (node == null) {
            return;
        }
        if (key.length() == 0) {
            node.val = val;
            return;
        }
        int index = indexOfChar(key.charAt(0));
        if (node.nodes[index] == null) {
            node.nodes[index] = new Node();
        }
        insert(key.substring(1), node.nodes[index], val);
    }

    private int indexOfChar(char c) {
        return c - 'a';
    }

    public int sum(String prefix) {
        sum = 0;
        sum(prefix, root);
        return sum;
    }

    private int sum;

    private void sum(String prefix, Node node) {
        if (node == null) {
            return;
        }
        if (prefix.length() == 0) {
            sum += node.val;
            for (int i = 0; i < 26; i++) {
                sum(prefix, node.nodes[i]);
            }
            return;
        }
        int index = indexOfChar(prefix.charAt(0));
        sum(prefix.substring(1), node.nodes[index]);
    }
}
