package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class KthSmallestElementInABst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println(new KthSmallestElementInABst().kthSmallest(root, 1));
    }

    private int count;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int res = kthSmallest(root.left, k);
        if (res != -1) {
            return res;
        }
        count++;
        if (count == k) {
            return root.val;
        }
        res = kthSmallest(root.right, k);
        return res;
    }
}
