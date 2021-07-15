package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class ConvertBstToGreaterTree {
    private int sum;

    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
    }
}
