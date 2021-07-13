package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/13
 */
public class AverageOfLevelsInBinaryTree {
    private List<Double> result = new ArrayList<>();
    private LinkedList<TreeNode> queue = new LinkedList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return result;
        }
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                sum += node.val;
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(sum / size);
        }
        return result;
    }
}
