package leetcode.tree.medium;

import leetcode.node.type1.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 窦康泰
 * @date 2021/07/13
 */
public class HouseRobberiii {
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int v1 = root.val;
        if (root.left != null) {
            v1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            v1 += rob(root.right.left) + rob(root.right.right);
        }
        int v2 = 0;
        v2 += rob(root.left) + rob(root.right);
        int result = Math.max(v1, v2);
        cache.put(root, result);
        return result;
    }
}
