package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class FindModeInBinarySearchTree {
    private List<Integer> list = new ArrayList<>();
    private TreeNode pre;
    private int count = 1;
    private int maxCount = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        help(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre != null) {
            if (pre.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (maxCount < count) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if (maxCount == count) {
            list.add(root.val);
        }
        pre = root;
        help(root.right);
    }
}
