package leetcode.bst.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/02/06
 */
public class ConvertBstToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }

    private int sum = 0;

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.right);
        sum += root.val;
        root.val = sum;
        help(root.left);
    }
}

