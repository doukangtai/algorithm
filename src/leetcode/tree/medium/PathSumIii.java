package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

/**
 * @author 窦康泰
 * @date 2021/05/08
 */
public class PathSumIii {
    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3));
        TreeNode right1 = new TreeNode(-3, new TreeNode(-2), null);
        TreeNode root = new TreeNode(1, left1, right1);
        System.out.println(new PathSumIii().pathSum(root, -1));
    }

    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        int num = help(root, targetSum);
        res += num;
        if (root != null) {
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
        }
        return res;
    }

    private int help(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        targetSum -= root.val;
        int sum = help(root.left, targetSum) + help(root.right, targetSum);
        return targetSum == 0 ? 1 + sum : sum;
    }
}
