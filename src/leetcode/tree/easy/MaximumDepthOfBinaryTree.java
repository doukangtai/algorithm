package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/04/28
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return help(root, 0);
    }

    private int help(TreeNode root, int dp) {
        if (root == null) {
            return dp;
        }
        return Math.max(help(root.left, dp + 1), help(root.right, dp + 1));
    }
}
