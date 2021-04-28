package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/04/28
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(root));
    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        res = Math.max(left + right, res);
        return Math.max(left, right) + 1;
    }
}
