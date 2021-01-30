package leetcode.tree.medium;

/**
 * @author 窦康泰
 * @date 2021/01/30
 */
public class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        merge(root.left, root.right);
        return root;
    }

    public void merge(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        left.next = right;
        merge(left.left, left.right);
        merge(right.left, right.right);
        merge(left.right, right.left);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
