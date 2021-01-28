package leetcode.dp.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/01/28
 */
public class HouseRobberiii {
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int robCurr = root.val
                + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int robNext = rob(root.left) + rob(root.right);
        int max = Math.max(robCurr, robNext);
        memo.put(root, max);
        return max;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
