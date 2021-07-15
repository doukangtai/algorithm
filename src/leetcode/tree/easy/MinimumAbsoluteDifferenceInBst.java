package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class MinimumAbsoluteDifferenceInBst {
    private int result = Integer.MAX_VALUE;
    private List<Integer> list = new ArrayList<>();

    public int getMinimumDifference(TreeNode root) {
        help(root);
        for (int i = 1; i < list.size(); i++) {
            int temp = list.get(i) - list.get(i - 1);
            result = Math.min(result, temp);
        }
        return result;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        list.add(root.val);
        help(root.right);
    }
}
