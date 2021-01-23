package leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 窦康泰
 * @date 2021/01/23
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(new MinimumDepthOfBinaryTree().minDepth(root));
    }

    private Queue<TreeNode> q = new LinkedList<>();
    private int dep = 1;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left == null && curr.right == null) {
                    return dep;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
            dep++;
        }
        return -1;
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
