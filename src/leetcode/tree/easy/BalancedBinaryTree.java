package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/04/28
 */
public class BalancedBinaryTree {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        help(root);
        return res;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        res &= Math.abs(left - right) <= 1;
        return Math.max(left, right) + 1;
    }
}
