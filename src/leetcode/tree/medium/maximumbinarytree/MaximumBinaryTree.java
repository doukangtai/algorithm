package leetcode.tree.medium.maximumbinarytree;

/**
 * @author 窦康泰
 * @date 2021/02/04
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int index = -1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, left, index - 1);
        root.right = build(nums, index + 1, right);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
