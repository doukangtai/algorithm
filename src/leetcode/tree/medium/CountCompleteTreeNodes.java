package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/02/08
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root;
        TreeNode right = root;
        int leftCount = 0;
        while (left != null) {
            left = left.left;
            leftCount++;
        }
        int rightCount = 0;
        while (right != null) {
            right = right.right;
            rightCount++;
        }
        if (leftCount == rightCount) {
            return (int) (Math.pow(2, leftCount) - 1);
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
