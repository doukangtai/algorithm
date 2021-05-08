package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/05/08
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }
        if (help(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean help(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }
        return help(root.left, subRoot.left) && help(root.right, subRoot.right);
    }
}
