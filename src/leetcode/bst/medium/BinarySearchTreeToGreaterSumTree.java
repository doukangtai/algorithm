package leetcode.bst.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/02/06
 */
public class BinarySearchTreeToGreaterSumTree {
    private int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }
        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);
        return root;
    }
}

