package leetcode.bst.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/02/06
 */
public class DeleteNodeInABst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                int min = getMin(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
