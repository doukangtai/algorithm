package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

import java.util.LinkedList;

/**
 * @author 窦康泰
 * @date 2021/07/13
 */
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        int result = Integer.MIN_VALUE;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                if (i == 0) {
                    result = node.val;
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
        }
        return result;
    }
}
