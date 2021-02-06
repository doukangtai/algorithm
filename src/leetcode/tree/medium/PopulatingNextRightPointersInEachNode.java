package leetcode.tree.medium;

import leetcode.node.type2.Node;

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
