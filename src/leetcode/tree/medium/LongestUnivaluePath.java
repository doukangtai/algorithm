package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/07/13
 */
public class LongestUnivaluePath {
    private int result;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        int leftPath = 0;
        if (root.left != null && root.left.val == root.val) {
            leftPath = leftDepth + 1;
        }
        int rightPath = 0;
        if (root.right != null && root.right.val == root.val) {
            rightPath = rightDepth + 1;
        }
        result = Math.max(result, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
