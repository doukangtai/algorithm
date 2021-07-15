package leetcode.tree.easy;

import leetcode.node.type1.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 窦康泰
 * @date 2021/07/14
 */
public class TwoSumIvInputIsABst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        System.out.println(new TwoSumIvInputIsABst().findTarget(root, 2));
    }

    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        help(root);
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k) {
                return true;
            } else if (sum > k) {
                r--;
            } else {
                l++;
            }
        }
        return false;
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
