package leetcode.bst.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/02/06
 */
public class KthSmallestElementInABst {
    private int count = 0;
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        help(root, k);
        return res;
    }

    public void help(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        help(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        help(root.right, k);
    }
}

