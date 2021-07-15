package leetcode.tree.medium;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.search("a");
    }

    class Node {
        Node[] nodes = new Node[26];
        boolean isLeaf;
    }

    private Node root = new Node();

    public Trie() {}

    public void insert(String word) {
        insert(word, root);
    }

    private void insert(String word, Node node) {
        if (node == null) {
            return;
        }
        if (word.length() == 0) {
            node.isLeaf = true;
            return;
        }
        int index = indexOfChar(word.charAt(0));
        if (node.nodes[index] == null) {
            node.nodes[index] = new Node();
        }
        insert(word.substring(1), node.nodes[index]);
    }

    private int indexOfChar(char c) {
        return c - 'a';
    }

    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, Node node) {
        if (node == null) {
            return false;
        }
        if (word.length() == 0) {
            return node.isLeaf;
        }
        int index = indexOfChar(word.charAt(0));
        return search(word.substring(1), node.nodes[index]);
    }

    public boolean startsWith(String prefix) {
        return startsWith(prefix, root);
    }

    private boolean startsWith(String prefix, Node node) {
        if (node == null) {
            return false;
        }
        if (prefix.length() == 0) {
            return true;
        }
        int index = indexOfChar(prefix.charAt(0));
        return startsWith(prefix.substring(1), node.nodes[index]);
    }
}
